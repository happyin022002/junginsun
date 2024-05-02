/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.05 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescRSQL").append("\n"); 
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
		query.append("/* Eur24BlCntrMfListVOs Eur24CustomsTransmissionDBDAOSearchBlCntrMfDesc ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo) */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("	   FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("	  WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("        AND RCVR_ID = 'ENS'" ).append("\n"); 
		query.append("        AND PCK_TP_CD = X.PCK_TP_CD),X.PCK_TP_CD)  AS D_PUNIT /* 120 */" ).append("\n"); 
		query.append("  , PCK_QTY         AS D_PKG   /* 121 */" ).append("\n"); 
		query.append("  , ''              AS D_WGT   /* 122 */" ).append("\n"); 
		query.append("  , MEAS_QTY        AS D_MEAS  /* 123 */" ).append("\n"); 
		query.append("  , BKG_SPCLCHAR_CONV_FNC(CNTR_MF_MK_DESC,'X') AS D_DESC  /* 124 */" ).append("\n"); 
		query.append("  , ''              AS D_MARK  /* 125 */" ).append("\n"); 
		query.append("  , VSL_CD,      SKD_VOY_NO,       SKD_DIR_CD,       BL_NO,     CSTMS_PORT_CD, CNTR_NO, CNTR_CGO_SEQ" ).append("\n"); 
		query.append("  , PCK_QTY,     CNTR_MF_MK_DESC,  CNTR_MF_GDS_DESC, PCK_TP_CD, MEAS_QTY" ).append("\n"); 
		query.append("  , CRE_USR_ID,  CRE_DT,           UPD_USR_ID,       UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_CNTR_MF X " ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND CNTR_NO    = @[cntr_no]" ).append("\n"); 

	}
}