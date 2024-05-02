/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonPopUpManageDBDAOSearchSCNOManageCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.17 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageDBDAOSearchSCNOManageCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSCNOManageCount
	  * </pre>
	  */
	public CommonPopUpManageDBDAOSearchSCNOManageCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : CommonPopUpManageDBDAOSearchSCNOManageCountRSQL").append("\n"); 
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
		query.append("select  count(*) cnt" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select --a.PROP_NO," ).append("\n"); 
		query.append("--b.AMDT_SEQ," ).append("\n"); 
		query.append("d.CUST_CNT_CD||d.CUST_SEQ CustomerCode," ).append("\n"); 
		query.append("d.cust_lgl_eng_nm CustomerName," ).append("\n"); 
		query.append("a.SC_NO SCNo," ).append("\n"); 
		query.append("d.ofc_cd SOffice," ).append("\n"); 
		query.append("'' cust_cnt_seq" ).append("\n"); 
		query.append("from   PRI_SP_HDR a," ).append("\n"); 
		query.append("(select ctrt.cust_cnt_cd" ).append("\n"); 
		query.append(", ctrt.cust_seq" ).append("\n"); 
		query.append(", ctrt.prop_no" ).append("\n"); 
		query.append(", ctrt.amdt_seq" ).append("\n"); 
		query.append("from pri_sp_ctrt_pty ctrt" ).append("\n"); 
		query.append("where ctrt.prc_ctrt_pty_tp_cd = 'C'" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select afil.cust_cnt_cd" ).append("\n"); 
		query.append(", afil.cust_seq" ).append("\n"); 
		query.append(", afil.prop_no" ).append("\n"); 
		query.append(", afil.amdt_seq" ).append("\n"); 
		query.append("from pri_sp_afil afil) b," ).append("\n"); 
		query.append("(select prop_no prop_no, AMDT_SEQ from pri_sp_mn where ((amdt_seq = 0 and prop_sts_cd = 'F')" ).append("\n"); 
		query.append("or (amdt_seq > 0))) c," ).append("\n"); 
		query.append("MDM_CUSTOMER d" ).append("\n"); 
		query.append("where a.PROP_NO = b.PROP_NO" ).append("\n"); 
		query.append("and   a.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("and   b.AMDT_SEQ = c.AMDT_SEQ" ).append("\n"); 
		query.append("and   b.CUST_CNT_CD = d.CUST_CNT_CD" ).append("\n"); 
		query.append("and   b.CUST_SEQ = d.CUST_SEQ" ).append("\n"); 
		query.append("and   nvl(d.nmd_cust_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cust_cnt_seq} != '')" ).append("\n"); 
		query.append("and d.cust_cnt_cd = substr(@[cust_cnt_seq],1,2)" ).append("\n"); 
		query.append("and d.cust_seq = substr(@[cust_cnt_seq], 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by d.cust_cnt_cd,d.cust_seq, d.cust_lgl_eng_nm, a.SC_NO, d.ofc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}