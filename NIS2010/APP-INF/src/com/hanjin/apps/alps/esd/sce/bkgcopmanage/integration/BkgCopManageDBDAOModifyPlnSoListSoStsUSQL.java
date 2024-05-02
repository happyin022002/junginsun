/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyPlnSoListSoStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.19
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.04.19 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyPlnSoListSoStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_pln_so_list 의 so status 를 변경 update 한다. (fm_cop_no 의 od 영역의 so status 를 unmatch 건이 아닐 경우에만 가져온다)
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyPlnSoListSoStsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyPlnSoListSoStsUSQL").append("\n"); 
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
		query.append("update sce_pln_so_list a" ).append("\n"); 
		query.append("set" ).append("\n"); 
		query.append("	trsp_so_sts_cd = NVL((select trsp_so_sts_cd from sce_pln_so_list where cop_no = @[fm_cop_no]" ).append("\n"); 
		query.append("						and cost_act_grp_cd like 'OD%' and rownum = 1), a.trsp_so_sts_cd)" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("	cop_no = @[to_cop_no]" ).append("\n"); 
		query.append("	and cost_act_grp_cd like 'OD%'" ).append("\n"); 

	}
}