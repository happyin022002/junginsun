/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchPrivBkgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.09.30 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchPrivBkgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking / container 별로 cycle no 로 조회시 이전 운송 booking no 와 booking status 를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchPrivBkgCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchPrivBkgCntrRSQL").append("\n"); 
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
		query.append("select b.bkg_no, h.cop_sts_cd" ).append("\n"); 
		query.append("    from sce_cop_hdr h," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        select a.bkg_no, a.cntr_no " ).append("\n"); 
		query.append("        from" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            select bbc.bkg_no, bbc.cntr_no, bbc.cre_dt  " ).append("\n"); 
		query.append("            from bkg_container bbc, bkg_booking bk, " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                select bkg_no, CNMV_CYC_NO, cntr_no, cre_dt " ).append("\n"); 
		query.append("                from bkg_container " ).append("\n"); 
		query.append("                where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("            ) bc       " ).append("\n"); 
		query.append("            where bbc.cntr_no = bc.cntr_no" ).append("\n"); 
		query.append("            and bbc.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("            and bk.bkg_cgo_tp_cd <>'P'" ).append("\n"); 
		query.append("            and bbc.cre_dt < bc.cre_dt" ).append("\n"); 
		query.append("            and bbc.CNMV_CYC_NO < bc.CNMV_CYC_NO" ).append("\n"); 
		query.append("            order by bbc.cre_dt desc" ).append("\n"); 
		query.append("        )a" ).append("\n"); 
		query.append("        where rownum =1 " ).append("\n"); 
		query.append("    ) b" ).append("\n"); 
		query.append("    where h.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("    and h.cntr_no = b.cntr_no" ).append("\n"); 
		query.append("    and rownum = 1" ).append("\n"); 

	}
}