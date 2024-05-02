/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * Manila 세관에 신고할 대상 B/L 정보를 조회한다.
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
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
		query.append("SELECT  REG_NUMBER2," ).append("\n"); 
		query.append("        POD," ).append("\n"); 
		query.append("        YEAR," ).append("\n"); 
		query.append("		BL_NO," ).append("\n"); 
		query.append("        CARGO_TYPE," ).append("\n"); 
		query.append("        ETL_CARGO_TYPE," ).append("\n"); 
		query.append("        SHIPPER_NAME," ).append("\n"); 
		query.append("        SHIPPER_ADDRESS1," ).append("\n"); 
		query.append("        SHIPPER_ADDRESS2," ).append("\n"); 
		query.append("        SHIPPER_ADDRESS3," ).append("\n"); 
		query.append("        SHIPPER_ADDRESS4," ).append("\n"); 
		query.append("        CONSIGNEE_NAME," ).append("\n"); 
		query.append("        CONSIGNEE_ADDRESS1," ).append("\n"); 
		query.append("        CONSIGNEE_ADDRESS2," ).append("\n"); 
		query.append("        CONSIGNEE_ADDRESS3," ).append("\n"); 
		query.append("        CONSIGNEE_ADDRESS4," ).append("\n"); 
		query.append("        NOTIFY_NAME," ).append("\n"); 
		query.append("        NOTIFY_ADDRESS1," ).append("\n"); 
		query.append("        NOTIFY_ADDRESS2," ).append("\n"); 
		query.append("        NOTIFY_ADDRESS3," ).append("\n"); 
		query.append("        NOTIFY_ADDRESS4," ).append("\n"); 
		query.append("        WEIGHT," ).append("\n"); 
		query.append("        VOLUME," ).append("\n"); 
		query.append("        COUNTRY_ORIGIN," ).append("\n"); 
		query.append("        TOTAL_CNTR," ).append("\n"); 
		query.append("        ROWNUM AS SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT @[reg_no]  reg_number2," ).append("\n"); 
		query.append("			   '' pod," ).append("\n"); 
		query.append("		       TO_NUMBER(TO_CHAR(SYSDATE,'RR')) year," ).append("\n"); 
		query.append("		       'SMLM'||NVL(BKG.BL_NO,' ') bl_no," ).append("\n"); 
		query.append("		       NVL(TO_NUMBER(DECODE(NVL(BKG.BKG_CGO_TP_CD,'F'),'F','1','B','3',DECODE(NVL(BKG.RCV_TERM_CD,'Y'),'S','2','0'))),0) cargo_type," ).append("\n"); 
		query.append("		       NVL(TO_NUMBER(DECODE(NVL(BKG.BKG_CGO_TP_CD,'F'),'F','1','B','3',DECODE(NVL(BKG.RCV_TERM_CD,'Y'),'S','2','0'))),0) etl_cargo_type," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(SHP.CUST_NM,CHR(13)||CHR(10),'  '),1,40),' '),'J') shipper_name," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(SHP.CUST_ADDR,CHR(13)||CHR(10),'  '),1,40),' '),'J') shipper_address1," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(SHP.CUST_ADDR,CHR(13)||CHR(10),'  '),41,40),' '),'J') shipper_address2," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(SHP.CUST_ADDR,CHR(13)||CHR(10),'  '),81,40),' '),'J') shipper_address3," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(SHP.CUST_ADDR,CHR(13)||CHR(10),'  '),121,40),' '),'J') shipper_address4," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(CSN.CUST_NM,CHR(13)||CHR(10),'  '),1,40),' '),'J') consignee_name," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(CSN.CUST_ADDR,CHR(13)||CHR(10),'  '),1,40),' '),'J') consignee_address1," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(CSN.CUST_ADDR,CHR(13)||CHR(10),'  '),41,40),' '),'J') consignee_address2," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(CSN.CUST_ADDR,CHR(13)||CHR(10),'  '),81,40),' '),'J') consignee_address3," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(CSN.CUST_ADDR,CHR(13)||CHR(10),'  '),121,40),' '),'J') consignee_address4," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(NTF.CUST_NM,CHR(13)||CHR(10),'  '),1,40),' '),'J') notify_name," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(NTF.CUST_ADDR,CHR(13)||CHR(10),'  '),1,40),' '),'J') notify_address1," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(NTF.CUST_ADDR,CHR(13)||CHR(10),'  '),41,40),' '),'J') notify_address2," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(NTF.CUST_ADDR,CHR(13)||CHR(10),'  '),81,40),' '),'J') notify_address3," ).append("\n"); 
		query.append("				BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(NTF.CUST_ADDR,CHR(13)||CHR(10),'  '),121,40),' '),'J') notify_address4," ).append("\n"); 
		query.append("		       NVL(DECODE(NVL(DOC.WGT_UT_CD,'KGS'),'KGS',NVL(DOC.ACT_WGT,0),'LBS',NVL(DOC.ACT_WGT,0)*0.45359),0) weight," ).append("\n"); 
		query.append("		       NVL(TO_CHAR(DECODE(NVL(DOC.MEAS_UT_CD,'CBM'),'CBM',NVL(DOC.MEAS_QTY,0),'CBF',NVL(DOC.MEAS_QTY,0)*0.02831)),' ') volume," ).append("\n"); 
		query.append("		       SUBSTR(NVL(BKG.POR_CD,' '),1,2) country_origin," ).append("\n"); 
		query.append("		       (SELECT COUNT(CNTR_NO)" ).append("\n"); 
		query.append("	              FROM BKG_CONTAINER" ).append("\n"); 
		query.append("	             WHERE BKG_CONTAINER.BKG_NO = NVL(BKG.BKG_NO,' ')" ).append("\n"); 
		query.append("	           ) total_cntr" ).append("\n"); 
		query.append("		 FROM BKG_CUSTOMER SHP," ).append("\n"); 
		query.append("		      BKG_CUSTOMER CSN," ).append("\n"); 
		query.append("		      BKG_CUSTOMER NTF," ).append("\n"); 
		query.append("		      BKG_BOOKING BKG," ).append("\n"); 
		query.append("		      BKG_VVD BV," ).append("\n"); 
		query.append("		      BKG_BL_DOC DOC" ).append("\n"); 
		query.append("		 WHERE SHP.BKG_NO(+)       = BKG.BKG_NO AND" ).append("\n"); 
		query.append("		       SHP.BKG_CUST_TP_CD          = 'S' AND" ).append("\n"); 
		query.append("		       CSN.BKG_NO(+)       = BKG.BKG_NO AND" ).append("\n"); 
		query.append("		       CSN.BKG_CUST_TP_CD          = 'C' AND" ).append("\n"); 
		query.append("		       NTF.BKG_NO(+)       = BKG.BKG_NO AND" ).append("\n"); 
		query.append("		       NTF.BKG_CUST_TP_CD          = 'N' AND" ).append("\n"); 
		query.append("		       BKG.BKG_NO          = BV.BKG_NO AND" ).append("\n"); 
		query.append("		       BKG.BKG_NO          = DOC.BKG_NO AND" ).append("\n"); 
		query.append("		       BV.VSL_CD           = @[vsl_cd] AND" ).append("\n"); 
		query.append("		       BV.SKD_VOY_NO    = @[skd_voy_no] AND" ).append("\n"); 
		query.append("		       BV.SKD_DIR_CD       = @[skd_dir_cd] AND" ).append("\n"); 
		query.append("			   #if (${pol_cd}!= '') " ).append("\n"); 
		query.append("		       BV.POL_CD          LIKE @[pol_cd] AND" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   #if (${pod_cd}!= '') " ).append("\n"); 
		query.append("		       BV.POD_CD          LIKE @[pod_cd] AND" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("		       BKG.BKG_STS_CD     IN ('F','W') AND" ).append("\n"); 
		query.append("		       BKG.BL_NO > ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}