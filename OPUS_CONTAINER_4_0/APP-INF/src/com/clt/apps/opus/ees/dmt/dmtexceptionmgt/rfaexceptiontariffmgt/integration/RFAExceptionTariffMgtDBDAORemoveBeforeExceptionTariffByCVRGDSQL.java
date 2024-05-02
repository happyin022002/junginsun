/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTariffByCVRGDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTariffByCVRGDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Coverage 정보가 삭제될 경우 Coverage Sequence 필드추가 인해서 중복입력된 Before Booking Request 정보도
	  * 같이 삭제해준다.
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTariffByCVRGDSQL(){
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
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTariffByCVRGDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF_DTL" ).append("\n"); 
		query.append("WHERE	(" ).append("\n"); 
		query.append("RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	CVRG_CMB_SEQ" ).append("\n"); 
		query.append(") IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",   RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",   RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",   RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",   CVRG_CMB_SEQ" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_DTL" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND	RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND	RFA_EXPT_VER_SEQ = @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",   RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",   RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",   RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",   CVRG_CMB_SEQ" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND	RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND	RFA_EXPT_VER_SEQ = @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}