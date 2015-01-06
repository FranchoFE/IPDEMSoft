import xml.dom.minidom

document = """\
<frameStructure>
  <title>Nueva ventana</title>
  <panel>
    <title negrita="2">Panel1</title>
    <point>This is a demo</point>
    <point>Of a program for processing slides</point>
  </panel>

  <panel>
    <title negrita="2">Panel2</title>
    <point>It is important</point>
    <point>To have more than</point>
    <button>one slide</button>
  </panel>
</frameStructure>
"""

dom = xml.dom.minidom.parseString(document)

def getText(nodelist):
    rc = ""
    for node in nodelist:
        if node.nodeType == node.TEXT_NODE:
            rc = rc + node.data
    return rc

def processFrameStructure(slideshow):
    print("--Frame Structure Analizer--")
    processFrameStructureTitle(slideshow.getElementsByTagName("title")[0])
    panels = slideshow.getElementsByTagName("panel")
    handleToc(panels)
    handlePanels(panels)

def handlePanels(panels):
    for panel in panels:
        handlePanel(panel)

def handlePanel(panel):
    handleSlideTitle(panel.getElementsByTagName("title")[0])
    handlePoints(panel.getElementsByTagName("point"))

def processFrameStructureTitle(title):
    print("Frame Title: %s" % getText(title.childNodes))

def handleSlideTitle(title):
    print ()
    print("%s" % getText(title.childNodes))

def handlePoints(points):
    for point in points:
        handlePoint(point)
    
def handlePoint(point):
    print("<li>%s</li>" % getText(point.childNodes))

def handleToc(panels):
    for panel in panels:
        title = panel.getElementsByTagName("title")[0]
        print("PanelTitle: %s" % getText(title.childNodes))
		

processFrameStructure(dom)
