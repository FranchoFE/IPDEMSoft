
import pymssql
import sys

conn = pymssql.connect(host='VTMOS_KLEIN0', user='misnt', password='misnt', database='MISNT_PROD')
cur = conn.cursor()

cur.execute('DELETE FROM [MISNT_PROD].[MISNT].[REF_WAY_POINT_CONNECTION] WHERE [ID] like 9700000')
cur.execute('DELETE FROM [MISNT_PROD].[MISNT].[REF_WAY_POINT_CONNECTION] WHERE [ID] like 9700001')

cur.execute('DELETE FROM [MISNT_PROD].[MISNT].[REF_WAY_POINT] WHERE [ID] like 8381522')
cur.execute('DELETE FROM [MISNT_PROD].[MISNT].[REF_WAY_POINT] WHERE [ID] like 9500000')

cur.execute('DELETE FROM [MISNT_PROD].[MISNT].[REF_LOCATION] WHERE [ID] like 8381504')
cur.execute('DELETE FROM [MISNT_PROD].[MISNT].[REF_LOCATION] WHERE [ID] like 9000000')
           
conn.commit()

conn.close()

