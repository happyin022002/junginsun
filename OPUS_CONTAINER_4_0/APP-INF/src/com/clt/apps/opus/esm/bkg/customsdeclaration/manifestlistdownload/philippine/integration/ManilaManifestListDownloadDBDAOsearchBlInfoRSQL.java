/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManilaManifestListDownloadDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchBlInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT REG_NUMBER2," ).append("\n"); 
		query.append("       YEAR," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       CARGO_TYPE," ).append("\n"); 
		query.append("       CARGO_TYPE AS ETL_CARGO_TYPE," ).append("\n"); 
		query.append("       SHIPPER_NAME1," ).append("\n"); 
		query.append("       SHIPPER_NAME2," ).append("\n"); 
		query.append("       SHIPPER_ADDRESS1," ).append("\n"); 
		query.append("       SHIPPER_ADDRESS2," ).append("\n"); 
		query.append("       SHIPPER_ADDRESS3," ).append("\n"); 
		query.append("       SHIPPER_ADDRESS4," ).append("\n"); 
		query.append("       CONSIGNEE_NAME1," ).append("\n"); 
		query.append("       CONSIGNEE_NAME2," ).append("\n"); 
		query.append("       CONSIGNEE_ADDRESS1," ).append("\n"); 
		query.append("       CONSIGNEE_ADDRESS2," ).append("\n"); 
		query.append("       CONSIGNEE_ADDRESS3," ).append("\n"); 
		query.append("       CONSIGNEE_ADDRESS4," ).append("\n"); 
		query.append("       NOTIFY_NAME1," ).append("\n"); 
		query.append("       NOTIFY_NAME2," ).append("\n"); 
		query.append("       NOTIFY_ADDRESS1," ).append("\n"); 
		query.append("       NOTIFY_ADDRESS2," ).append("\n"); 
		query.append("       NOTIFY_ADDRESS3," ).append("\n"); 
		query.append("       NOTIFY_ADDRESS4," ).append("\n"); 
		query.append("       WEIGHT," ).append("\n"); 
		query.append("       VOLUME," ).append("\n"); 
		query.append("       COUNTRY_ORIGIN," ).append("\n"); 
		query.append("       POD," ).append("\n"); 
		query.append("       TOTAL_CNTR," ).append("\n"); 
		query.append("       ROWNUM AS SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT @[reg_no] AS REG_NUMBER2," ).append("\n"); 
		query.append("               TO_NUMBER(TO_CHAR(SYSDATE, 'RR')) AS YEAR," ).append("\n"); 
		query.append("               COM_CONSTANTMGR_PKG.COM_GETSCACCODE_FNC()||NVL(BKG.BL_NO, ' ') AS BL_NO," ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                  WHEN BKG.BKG_CGO_TP_CD IN ('P', 'R') THEN 'EMT' --EMT" ).append("\n"); 
		query.append("                  WHEN BKG.BB_CGO_FLG = 'Y' THEN 'BULK'" ).append("\n"); 
		query.append("                  WHEN NVL(BKG.RCV_TERM_CD, 'Y') = 'S' THEN 'LCL' --PARTIAL" ).append("\n"); 
		query.append("                  ELSE 'FCL'" ).append("\n"); 
		query.append("               END AS CARGO_TYPE," ).append("\n"); 
		query.append("--             NVL(TO_NUMBER(DECODE(NVL(BKG.BKG_CGO_TP_CD, 'F'), 'F', '1', 'B', '3', DECODE(NVL(BKG.RCV_TERM_CD, 'Y'), 'S', '2', '0'))), 0) AS CARGO_TYPE," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(SHP.CUST_NM, CHR(10), '  '), 1, 35), ' ') AS SHIPPER_NAME1," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(SHP.CUST_NM, CHR(10), '  '), 36, 35), ' ') AS SHIPPER_NAME2," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(SHP.CUST_ADDR, CHR(10), '  '), 1, 35), ' ') AS SHIPPER_ADDRESS1," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(SHP.CUST_ADDR, CHR(10), '  '), 36, 35), ' ') AS SHIPPER_ADDRESS2," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(SHP.CUST_ADDR, CHR(10), '  '), 71, 35), ' ') AS SHIPPER_ADDRESS3," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(SHP.CUST_ADDR, CHR(10), '  '), 106, 36), ' ') AS SHIPPER_ADDRESS4," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(CSN.CUST_NM, CHR(10), '  '), 1, 35), ' ') AS CONSIGNEE_NAME1," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(CSN.CUST_NM, CHR(10), '  '), 36, 35), ' ') AS CONSIGNEE_NAME2," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(CSN.CUST_ADDR, CHR(10), '  '), 1, 35), ' ') AS CONSIGNEE_ADDRESS1," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(CSN.CUST_ADDR, CHR(10), '  '), 36, 35), ' ') AS CONSIGNEE_ADDRESS2," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(CSN.CUST_ADDR, CHR(10), '  '), 71, 35), ' ') AS CONSIGNEE_ADDRESS3," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(CSN.CUST_ADDR, CHR(10), '  '), 106, 35), ' ') AS CONSIGNEE_ADDRESS4," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(NTF.CUST_NM, CHR(10), '  '), 1, 35), ' ') AS NOTIFY_NAME1," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(NTF.CUST_NM, CHR(10), '  '), 36, 35), ' ') AS NOTIFY_NAME2," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(NTF.CUST_ADDR, CHR(10), '  '), 1, 35), ' ') AS NOTIFY_ADDRESS1," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(NTF.CUST_ADDR, CHR(10), '  '), 36, 35), ' ') AS NOTIFY_ADDRESS2," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(NTF.CUST_ADDR, CHR(10), '  '), 71, 35), ' ') AS NOTIFY_ADDRESS3," ).append("\n"); 
		query.append("               NVL(SUBSTR(REPLACE(NTF.CUST_ADDR, CHR(10), '  '), 106, 35), ' ') AS NOTIFY_ADDRESS4," ).append("\n"); 
		query.append("               ROUND(NVL(DECODE(NVL(DOC.WGT_UT_CD, 'KGS'), 'KGS', NVL(DOC.ACT_WGT, 0), 'LBS', NVL(DOC.ACT_WGT, 0)*0.45359), 0), 2) AS WEIGHT," ).append("\n"); 
		query.append("               ROUND(NVL(TO_CHAR(DECODE(NVL(DOC.MEAS_UT_CD, 'CBM'), 'CBM', NVL(DOC.MEAS_QTY, 0), 'CBF', NVL(DOC.MEAS_QTY, 0)*0.02831)), 0), 3) AS VOLUME," ).append("\n"); 
		query.append("               (SELECT MDM.UN_LOC_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("                 WHERE MDM.LOC_CD = BKG.POR_CD) AS COUNTRY_ORIGIN," ).append("\n"); 
		query.append("               (SELECT MDM.UN_LOC_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("                 WHERE MDM.LOC_CD = BKG.POD_CD) AS POD," ).append("\n"); 
		query.append("               (SELECT COUNT(CNTR_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                 WHERE BKG_CONTAINER.BKG_NO = NVL(BKG.BKG_NO, ' ')) AS TOTAL_CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER SHP," ).append("\n"); 
		query.append("               BKG_CUSTOMER CSN," ).append("\n"); 
		query.append("               BKG_CUSTOMER NTF," ).append("\n"); 
		query.append("               BKG_BOOKING BKG," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               BKG_BL_DOC DOC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE SHP.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND SHP.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("           AND CSN.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND CSN.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND NTF.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND NTF.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("           AND BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("           AND BV.POL_CD LIKE @[pol_cd] " ).append("\n"); 
		query.append("#end #if (${pod_cd} != '')" ).append("\n"); 
		query.append("           AND BV.POD_CD LIKE @[pod_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("           AND BKG.BL_NO > ' '" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}