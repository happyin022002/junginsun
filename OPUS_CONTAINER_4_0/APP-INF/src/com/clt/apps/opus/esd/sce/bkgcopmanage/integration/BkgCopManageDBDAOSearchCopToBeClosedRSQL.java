/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopToBeClosedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.05 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchCopToBeClosedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * attachCntr 호출을 받았을 때 해당 container 가 다른 vvd 의 booking 에서 inbound 운송 진행 중일 경우 
	  * lcl 을 포함한 모든 cop 를 찾아서 return 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopToBeClosedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopToBeClosedRSQL").append("\n"); 
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
		query.append("select bkg_no,  cop_no, cntr_no" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where (  trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd ) in (" ).append("\n"); 
		query.append("select  trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and cop_sts_cd in ('C', 'T' )" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("SELECT vsl_cd trnk_vsl_cd, skd_voy_no trnk_skd_voy_no, skd_dir_cd trnk_skd_dir_cd" ).append("\n"); 
		query.append("FROM bkg_booking" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and cop_sts_cd in ('C', 'T' )" ).append("\n"); 

	}
}