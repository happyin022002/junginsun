/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAODuplicateBeforeExceptionVersionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.25 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAODuplicateBeforeExceptionVersionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중복된 Version 이 있는지 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAODuplicateBeforeExceptionVersionRSQL(){
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
		query.append("COUNT(RFA_EXPT_VER_SEQ) CNT" ).append("\n"); 
		query.append("FROM 	DMT_RFA_EXPT_TRF" ).append("\n"); 
		query.append("WHERE	RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND	RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND	RFA_EXPT_VER_SEQ = @[rfa_expt_ver_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration ").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAODuplicateBeforeExceptionVersionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}