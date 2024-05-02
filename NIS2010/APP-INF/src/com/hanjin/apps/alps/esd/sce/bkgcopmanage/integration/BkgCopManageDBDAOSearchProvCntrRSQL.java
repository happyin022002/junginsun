/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchProvCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchProvCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WRS 를 통해 Provision container no 를 받은 cop 를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchProvCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchProvCntrRSQL").append("\n"); 
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
		query.append("SELECT cop_no, bkg_no, cop_sts_cd " ).append("\n"); 
		query.append("FROM sce_cop_hdr " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("	and prov_cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("	and prov_cntr_tpsz_cd = (select cntr_tpsz_cd from bkg_container where " ).append("\n"); 
		query.append("						bkg_no = @[bkg_no] and cntr_no = @[cntr_no])" ).append("\n"); 
		query.append("	and cntr_no = 'SMCU0000000'" ).append("\n"); 
		query.append("	and cop_sts_cd in ('C', 'T')" ).append("\n"); 

	}
}