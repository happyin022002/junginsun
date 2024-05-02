/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListEqrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.10.22 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingCancelManageDBDAOMultiCancelRailBillingListEqrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail So의 EQR 상태코드 변경
	  * </pre>
	  */
	public RailBillingCancelManageDBDAOMultiCancelRailBillingListEqrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration").append("\n"); 
		query.append("FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListEqrUSQL").append("\n"); 
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
		query.append("UPDATE EQR_REPO_EXE_SO_IF" ).append("\n"); 
		query.append("SET TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("WHERE TRSP_SO_STS_CD IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF A," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD B" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND   A.PLN_YRWK = B.PLN_YRWK" ).append("\n"); 
		query.append("AND   A.REF_ID = B.REF_ID" ).append("\n"); 
		query.append("AND   A.REF_SEQ = B.REF_SEQ" ).append("\n"); 
		query.append("AND   B.TRSP_SO_OFC_CTY_CD = @[trspSoOfcCtyCd]" ).append("\n"); 
		query.append("AND   B.TRSP_SO_SEQ = @[trspSoSeq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}