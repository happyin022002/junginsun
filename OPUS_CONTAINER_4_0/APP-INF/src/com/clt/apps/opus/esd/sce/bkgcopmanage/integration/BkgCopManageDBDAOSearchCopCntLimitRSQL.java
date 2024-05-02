/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopCntLimitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.28
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.09.28 김인수
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

public class BkgCopManageDBDAOSearchCopCntLimitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_quantity 와 bkg_container 의 type size 별 count 차이를 구해 type size 별 최대 존재 가능한 COP 개수를 return 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopCntLimitRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopCntLimitRSQL").append("\n"); 
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
		query.append("select a.bkg_no, a.cntr_tpsz_cd," ).append("\n"); 
		query.append("ceil(a.op_cntr_qty) as op_cntr_qty," ).append("\n"); 
		query.append("nvl(cntr_cnt, 0) as cntr_cnt," ).append("\n"); 
		query.append("case when ceil(a.op_cntr_qty) - nvl(cntr_cnt, 0) <0 then 0 else ceil(a.op_cntr_qty) - nvl(cntr_cnt, 0) - nvl(cop_cnt, 0) end as cop_limit" ).append("\n"); 
		query.append("from bkg_quantity a," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select bkg_no," ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("count(*) as cntr_cnt" ).append("\n"); 
		query.append("from bkg_container" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and nvl(cntr_delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("group by bkg_no, cntr_tpsz_cd) b," ).append("\n"); 
		query.append("(select bkg_no, cntr_tpsz_cd, count(*) as cop_cnt from sce_cop_hdr where bkg_no = @[bkg_no] and cop_sts_cd != 'X' group by bkg_no, cntr_tpsz_cd ) h" ).append("\n"); 
		query.append("where a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and a.bkg_no = b.bkg_no (+)" ).append("\n"); 
		query.append("and a.cntr_tpsz_cd = b.cntr_tpsz_cd (+)" ).append("\n"); 
		query.append("and a.bkg_no = h.bkg_no" ).append("\n"); 
		query.append("and a.cntr_tpsz_cd = h.cntr_tpsz_cd" ).append("\n"); 

	}
}