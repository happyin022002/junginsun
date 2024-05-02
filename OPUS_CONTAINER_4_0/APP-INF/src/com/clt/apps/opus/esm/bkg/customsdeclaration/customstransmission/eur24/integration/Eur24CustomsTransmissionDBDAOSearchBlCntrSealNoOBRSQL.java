/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.08.05 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOBRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOBRSQL(){
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
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOBRSQL").append("\n"); 
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
		query.append("/* Eur24BlCntrSealListVOs Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo) */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   'SH'     AS SEAL_TYPE /* 130 */" ).append("\n"); 
		query.append("  , SEAL_NO AS SEAL_NBR  /* 131 */" ).append("\n"); 
		query.append("  , VSL_CD,        SKD_VOY_NO,        SKD_DIR_CD,      BL_NO,            CSTMS_PORT_CD,     CNTR_NO,  SEAL_NO_SEQ" ).append("\n"); 
		query.append("  , SEAL_NO,       SEAL_PTY_TP_CD,    SEAL_PTY_NM,     SEAL_KND_CD" ).append("\n"); 
		query.append("  , CRE_USR_ID,    CRE_DT,            UPD_USR_ID,      UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_SEAL_NO" ).append("\n"); 
		query.append("WHERE BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND CNTR_NO    = @[cntr_no]" ).append("\n"); 

	}
}