/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PlanMgtDBDAOsearchGuidelineInfoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.03.15 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOsearchGuidelineInfoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline 정보를 조회하는 Operation
	  * </pre>
	  */
	public PlanMgtDBDAOsearchGuidelineInfoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOsearchGuidelineInfoListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         A.MNR_GLINE_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_GLINE_NM" ).append("\n"); 
		query.append("        ,A.MNR_GLINE_RMK" ).append("\n"); 
		query.append("        ,A.FILE_SEQ" ).append("\n"); 
		query.append("        ,A.FILE_DTL_SEQ" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.UPD_DT, @[ofc_cd]), 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        ,(SELECT OFC_CD FROM COM_USER WHERE USR_ID = A.CRE_USR_ID AND ROWNUM = 1) UPD_OFC_CD" ).append("\n"); 
		query.append("        ,B.ORG_FILE_NM ORG_FILE_NM" ).append("\n"); 
		query.append("        ,DECODE(A.file_seq, 0, '1','0') FILE_DW" ).append("\n"); 
		query.append("        ,B.FILE_PATH_NM" ).append("\n"); 
		query.append("FROM MNR_GUIDELINE A, MNR_FILE_ATCH B" ).append("\n"); 
		query.append("WHERE A.MNR_GRP_TP_CD LIKE DECODE(@[mnr_grp_tp_cd], 'ALL', '', @[mnr_grp_tp_cd])||'%%'" ).append("\n"); 
		query.append("AND   A.FILE_SEQ     = B.FILE_SEQ(+)" ).append("\n"); 
		query.append("AND   A.FILE_DTL_SEQ = B.FILE_DTL_SEQ(+)" ).append("\n"); 

	}
}