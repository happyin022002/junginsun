/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageDBDAOIsPseudoYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.11 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOIsPseudoYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsPseudoYard
	  * </pre>
	  */
	public InlandRouteManageDBDAOIsPseudoYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOIsPseudoYardRSQL").append("\n"); 
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
		query.append("select nvl(y1.YD_FCTY_TP_PSDO_YD_FLG,'N') ORG, nvl(y2.YD_FCTY_TP_PSDO_YD_FLG,'N') DEST" ).append("\n"); 
		query.append("from MDM_YARD y1, MDM_YARD y2 ," ).append("\n"); 
		query.append("(SELECT @[i_rout_org_nod_cd] ORG, @[i_rout_dest_nod_cd] DEST FROM DUAL) D" ).append("\n"); 
		query.append("where y1.YD_CD(+)= D.org" ).append("\n"); 
		query.append("and y2.YD_CD(+)= D.dest" ).append("\n"); 

	}
}