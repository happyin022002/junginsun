/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchAncsCstmsFltFileCusrepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchAncsCstmsFltFileCusrepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ancs 에 전송할 CUSREP msg.의 Vessel 기본 정보를 조회한다.
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchAncsCstmsFltFileCusrepRSQL(){
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
		params.put("trans_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchAncsCstmsFltFileCusrepRSQL").append("\n"); 
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
		query.append("SELECT VVD.SVC_RQST_NO AS GD_NUMBER" ).append("\n"); 
		query.append(",VVD.LLOYD_TP_CD||VVD.LLOYD_NO AS LLOYD_CODE" ).append("\n"); 
		query.append(",A.REF_SEQ AS SEQ" ).append("\n"); 
		query.append(",@[trans_flag] AS UPDATE_IND" ).append("\n"); 
		query.append(",B.REF_SEQ AS PREV_DOCNO" ).append("\n"); 
		query.append(",VVD.DEP_LOC_CD AS BEGIN_PORT" ).append("\n"); 
		query.append(",'Y' AS DISCHARGE_IND --양하 여부, 항상 'Y' 임" ).append("\n"); 
		query.append(",VVD.BRTH_DESC AS BERTH" ).append("\n"); 
		query.append(",VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",VVD.VVD_NM AS VESSELNAME" ).append("\n"); 
		query.append(",VVD.VSL_CNT_CD AS VESSELFLAG" ).append("\n"); 
		query.append(",TO_CHAR(VVD.ETA_DT,'YYYYMMDD') AS ETA" ).append("\n"); 
		query.append(",C.MSG_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD VVD," ).append("\n"); 
		query.append("( SELECT TO_CHAR(NVL(MAX(B.REF_SEQ), 0) + 1, 'FM000000') AS REF_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD A, BKG_CSTMS_ANR_EDI_HIS B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.MSG_TP_CD(+) = 'R' -- CUSREP" ).append("\n"); 
		query.append("AND B.ANR_DECL_NO(+) = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO ) A," ).append("\n"); 
		query.append("( SELECT B.ANR_DECL_NO || 'CUSREP' || TO_CHAR(NVL(MAX(B.REF_SEQ), 0), 'FM000000') AS REF_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD A, BKG_CSTMS_ANR_EDI_HIS B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.MSG_TP_CD(+) = 'R' -- CUSREP" ).append("\n"); 
		query.append("AND B.ANR_DECL_NO(+) = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO" ).append("\n"); 
		query.append("GROUP BY B.ANR_DECL_NO ) B," ).append("\n"); 
		query.append("( SELECT  TO_CHAR(NVL(MAX(MSG.MSG_SEQ), 0) + 1, 'FM000000') AS MSG_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD VVD, BKG_CSTMS_ANR_EDI_MSG MSG," ).append("\n"); 
		query.append("(SELECT TO_CHAR(NVL(MAX(B.REF_SEQ), 0) + 1, 'FM000000') AS REF_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD A, BKG_CSTMS_ANR_EDI_HIS B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.MSG_TP_CD(+) = 'R' -- CUSREP" ).append("\n"); 
		query.append("AND B.ANR_DECL_NO(+) = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND MSG.REF_SEQ = A.REF_SEQ" ).append("\n"); 
		query.append("AND VVD.SVC_RQST_NO || VVD.LLOYD_TP_CD || VVD.LLOYD_NO = MSG.ANR_DECL_NO ) C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VVD.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 

	}
}