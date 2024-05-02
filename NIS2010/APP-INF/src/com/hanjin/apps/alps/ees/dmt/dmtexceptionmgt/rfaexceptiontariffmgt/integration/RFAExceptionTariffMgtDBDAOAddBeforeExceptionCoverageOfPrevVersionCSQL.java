/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageOfPrevVersionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageOfPrevVersionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 버전의 모든Before Booking Request 의Detail 에 해당되는  Multi Origin or Dest. 정보를 신규 버전으로 생성하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageOfPrevVersionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_prev_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageOfPrevVersionCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("SELECT	RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	@[rfa_expt_ver_seq]" ).append("\n"); 
		query.append(",	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	CVRG_CMB_SEQ" ).append("\n"); 
		query.append(",	CVRG_CONTI_CD" ).append("\n"); 
		query.append(",	CVRG_CNT_CD" ).append("\n"); 
		query.append(",	CVRG_RGN_CD" ).append("\n"); 
		query.append(",	CVRG_STE_CD" ).append("\n"); 
		query.append(",	CVRG_LOC_CD" ).append("\n"); 
		query.append(",	ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	ORG_DEST_STE_CD" ).append("\n"); 
		query.append(",	ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO		= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND	RFA_EXPT_MAPG_SEQ	= @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ	= @[rfa_expt_prev_ver_seq]" ).append("\n"); 

	}
}