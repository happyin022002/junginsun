/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOModifySoListFrstByTroCnfmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.31
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.31 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifySoListFrstByTroCnfmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO Confirm 시 해당 COP 로 s/o 생성대상 route 가 frustrated 되어 있을 경우 이 status 를 다시 planned 로 복구한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifySoListFrstByTroCnfmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifySoListFrstByTroCnfmUSQL").append("\n"); 
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
		query.append("update sce_pln_so_list" ).append("\n"); 
		query.append("set trsp_so_sts_cd = 'P'" ).append("\n"); 
		query.append("where cop_no = @[cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd like @[io_bnd_cd]||'D%'" ).append("\n"); 
		query.append("and trsp_so_sts_cd = 'F'" ).append("\n"); 

	}
}