/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.10.22 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail So의 Cargo Type를 조회
	  * </pre>
	  */
	public RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration ").append("\n"); 
		query.append("FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoRSQL").append("\n"); 
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
		query.append("CGO_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ = @[so_seq]" ).append("\n"); 

	}
}