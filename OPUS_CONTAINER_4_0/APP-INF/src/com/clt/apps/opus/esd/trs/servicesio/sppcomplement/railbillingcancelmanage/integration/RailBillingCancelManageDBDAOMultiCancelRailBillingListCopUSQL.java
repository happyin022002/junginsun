/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListCopUSQL.java
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

public class RailBillingCancelManageDBDAOMultiCancelRailBillingListCopUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail So의 COP 상태코드 변경
	  * </pre>
	  */
	public RailBillingCancelManageDBDAOMultiCancelRailBillingListCopUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration").append("\n"); 
		query.append("FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListCopUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("SET TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("WHERE (COP_NO, COST_ACT_GRP_SEQ) IN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trspSoOfcCtyCd]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ = @[trspSoSeq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}