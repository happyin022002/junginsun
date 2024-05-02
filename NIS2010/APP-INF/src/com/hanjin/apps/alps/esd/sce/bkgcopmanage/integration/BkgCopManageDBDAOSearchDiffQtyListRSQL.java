/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchDiffQtyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.03
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.02.03 홍성필
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

public class BkgCopManageDBDAOSearchDiffQtyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_cop_hdr 와 bkg_container 의 type size 별 개수 차이를 type size 별로 return 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchDiffQtyListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchDiffQtyListRSQL").append("\n"); 
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
		query.append("select cop.cntr_tpsz_cd," ).append("\n"); 
		query.append("  cop.pseudo_cnt," ).append("\n"); 
		query.append("  cop.attach_cnt," ).append("\n"); 
		query.append("  cntr.cntr_cnt," ).append("\n"); 
		query.append("  qty.qty" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select cntr_tpsz_cd," ).append("\n"); 
		query.append("      sum(decode (cntr_no, 'SMCU0000000', 1, 0)) as pseudo_cnt," ).append("\n"); 
		query.append("      sum(decode (cntr_no, 'SMCU0000000', 0, 1)) as attach_cnt" ).append("\n"); 
		query.append("    from sce_cop_hdr" ).append("\n"); 
		query.append("    where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("      and cop_sts_cd not in ('X'," ).append("\n"); 
		query.append("          'O'," ).append("\n"); 
		query.append("          'M')" ).append("\n"); 
		query.append("    group by cntr_tpsz_cd) cop," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    select cntr_tpsz_cd," ).append("\n"); 
		query.append("      count(*) as cntr_cnt" ).append("\n"); 
		query.append("    from bkg_container" ).append("\n"); 
		query.append("    where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("      and nvl(CNTR_DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    group by cntr_tpsz_cd) cntr," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    select cntr_tpsz_cd," ).append("\n"); 
		query.append("      sum(ceil(NVL(op_cntr_qty, 0))) as qty" ).append("\n"); 
		query.append("    from bkg_quantity" ).append("\n"); 
		query.append("    where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("    group by cntr_tpsz_cd ) qty" ).append("\n"); 
		query.append("where cop.cntr_tpsz_cd = cntr.cntr_tpsz_Cd (+)" ).append("\n"); 
		query.append("  and cop.cntr_tpsz_cd = qty.cntr_tpsz_Cd (+)" ).append("\n"); 

	}
}