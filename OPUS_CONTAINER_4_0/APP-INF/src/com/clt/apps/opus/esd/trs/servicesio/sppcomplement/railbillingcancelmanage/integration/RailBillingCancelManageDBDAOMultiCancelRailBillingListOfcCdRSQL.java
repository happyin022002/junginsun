/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListOfcCdRSQL.java
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

public class RailBillingCancelManageDBDAOMultiCancelRailBillingListOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor의 Ofice code 조회
	  * </pre>
	  */
	public RailBillingCancelManageDBDAOMultiCancelRailBillingListOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration ").append("\n"); 
		query.append("FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListOfcCdRSQL").append("\n"); 
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
		query.append("OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndrSeq]" ).append("\n"); 

	}
}