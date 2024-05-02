/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOAddSendDtlLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.15 김경섭
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

public class Eur24CustomsTransmissionDBDAOAddSendDtlLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOAddSendDtlLogCSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOAddSendDtlLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOAddSendDtlLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VSL_CD,     SKD_VOY_NO,    SKD_DIR_CD,    BL_NO,        CSTMS_PORT_CD" ).append("\n"); 
		query.append(", BKG_POL_CD, BKG_POD_CD,    POL_CD,        POD_CD,       DEL_CD" ).append("\n"); 
		query.append(", POL_NM,     POD_NM,        DEL_NM,        PCK_QTY,      PCK_TP_CD" ).append("\n"); 
		query.append(", MEAS_QTY,   MEAS_UT_CD,    CMDT_CD,       TRSP_DOC_NO,  CSTMS_DECL_DT,  DECL_LOC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID, CRE_DT,        UPD_USR_ID,    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.VSL_CD,    X.SKD_VOY_NO,  X.SKD_DIR_CD,  X.BL_NO,      X.CSTMS_PORT_CD" ).append("\n"); 
		query.append(",BKG.POL_CD,  BKG.POD_CD,    VVD.POL_CD,    VVD.POD_CD,   BKG.DEL_CD" ).append("\n"); 
		query.append(",BD.POL_NM,   BD.POD_NM,     BD.DEL_NM,     BD.PCK_QTY,   BD.PCK_TP_CD" ).append("\n"); 
		query.append(",BD.MEAS_QTY, BD.MEAS_UT_CD, BKG.CMDT_CD,   NULL,         NULL,            NULL" ).append("\n"); 
		query.append(",@[cre_usr_id],SYSDATE,     @[cre_usr_id],  SYSDATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(COLUMN_VALUE,1) AS VSL_CD" ).append("\n"); 
		query.append(", BKG_GET_TOKEN_FNC(COLUMN_VALUE,2) AS SKD_VOY_NO" ).append("\n"); 
		query.append(", BKG_GET_TOKEN_FNC(COLUMN_VALUE,3) AS SKD_DIR_CD" ).append("\n"); 
		query.append(", BKG_GET_TOKEN_FNC(COLUMN_VALUE,4) AS BL_NO" ).append("\n"); 
		query.append(", BKG_GET_TOKEN_FNC(COLUMN_VALUE,5) AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("FROM TABLE(BKG_SPLIT_CLOB_FNC(${cntr_list},'@'))" ).append("\n"); 
		query.append("WHERE COLUMN_VALUE IS NOT NULL" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("BKG_BOOKING BKG," ).append("\n"); 
		query.append("BKG_VVD VVD," ).append("\n"); 
		query.append("BKG_BL_DOC BD" ).append("\n"); 
		query.append("WHERE X.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("AND VVD.VSL_CD        = X.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO    = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD    = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BKG.BKG_NO = BD.BKG_NO" ).append("\n"); 

	}
}