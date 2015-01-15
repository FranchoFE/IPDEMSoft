
import pymssql
import sys

conn = pymssql.connect(host='VTMOS_KLEIN0', user='misnt', password='misnt', database='MISNT_PROD')
cur = conn.cursor()

cur.execute('INSERT INTO [MISNT_PROD].[MISNT].[REF_LOCATION] ([ID], [DOMAIN_ID], [NAME], [CODE], [LOCATION_TYPE], [TO_VTS_AREA_TIME], [SWING_TIME], [LASTMODIFIEDBY], [DELETED], [PIER_MARK_INTERVAL], [ANCH_REF_POSITION], [HEADIN_IS_PORTSIDE], [OF_INTEREST]) VALUES (9000005, 5785758, \'FFEName\', \'FFE\', 620, 0, 0, 0, 0, 1, 0, 0, 0)')

cur.execute('INSERT INTO [MISNT_PROD].[MISNT].[REF_WAY_POINT] ([ID], [VTS_WAY_POINT_NAME], [LOCATION_ID], [LASTMODIFIEDBY], [DELETED], [REPORT_NAME], [IS_MIS_WAY_POINT], [VISIBLE], [DOMAIN_ID]) VALUES (9500000, \'AUTOCREATED\', 9000000, 0, 0, \'AAC\', 1, 1, 5785758)')

cur.execute('INSERT INTO [MISNT_PROD].[MISNT].[REF_WAY_POINT_CONNECTION] ([ID], [FROM_WP_ID], [TO_WP_ID], [TRAVEL_TIME], [TRAVEL_DISTANCE], [VISIBLE], [PRIORITY], [DRAFT]) VALUES (9700000, 9500000, 8381508, 7, 70, 1, 7, 77)')

cur.execute('INSERT INTO [MISNT_PROD].[MISNT].[REF_WAY_POINT_CONNECTION] ([ID], [FROM_WP_ID], [TO_WP_ID], [TRAVEL_TIME], [TRAVEL_DISTANCE], [VISIBLE], [PRIORITY], [DRAFT]) VALUES (9700001, 8381508, 9500000, 8, 80, 1, 8, 88)')
           
#row = cur.fetchone()

conn.close()

