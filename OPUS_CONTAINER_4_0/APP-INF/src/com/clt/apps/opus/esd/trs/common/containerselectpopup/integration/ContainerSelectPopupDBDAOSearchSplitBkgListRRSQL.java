/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchSplitBkgListRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2010.04.23 조풍연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author POONG-YEON CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSelectPopupDBDAOSearchSplitBkgListRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * current bkg와 split된 bkg list 조회
	  * </pre>
	  */
	public ContainerSelectPopupDBDAOSearchSplitBkgListRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orgBkgNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.containerselectpopup.integration").append("\n"); 
		query.append("FileName : ContainerSelectPopupDBDAOSearchSplitBkgListRRSQL").append("\n"); 
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
		query.append("A.BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.BKG_NO          =  @[bkgNo]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.BKG_NO          =  @[orgBkgNo]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.FM_BKG_NO       =     @[bkgNo]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.FM_BKG_NO        =    @[orgBkgNo]" ).append("\n"); 

	}
}