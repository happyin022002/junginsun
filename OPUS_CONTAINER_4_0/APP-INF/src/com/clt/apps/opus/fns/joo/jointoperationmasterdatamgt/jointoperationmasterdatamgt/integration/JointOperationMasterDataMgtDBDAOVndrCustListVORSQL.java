/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOVndrCustListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.19 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtDBDAOVndrCustListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOVndrCustListVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("a.jo_crr_cd," ).append("\n"); 
		query.append("a.trd_cd," ).append("\n"); 
		query.append("a.rlane_cd," ).append("\n"); 
		query.append("''||a.vndr_seq as vndr_seq," ).append("\n"); 
		query.append("a.cust_cnt_cd||lpad(a.cust_seq,6,'0') as cust_seq," ).append("\n"); 
		query.append("nvl(c.cust_lgl_eng_nm, b.vndr_lgl_eng_nm) as cust_lgl_eng_nm," ).append("\n"); 
		query.append("nvl(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select /*+index_desc(x xpkmdm_cust_addr)*/" ).append("\n"); 
		query.append("x.bzet_addr" ).append("\n"); 
		query.append("from   mdm_cust_addr x" ).append("\n"); 
		query.append("where  x.cust_cnt_cd = a.cust_cnt_cd" ).append("\n"); 
		query.append("and    x.cust_seq    = a.cust_seq" ).append("\n"); 
		query.append("and    x.addr_tp_cd  = '1'" ).append("\n"); 
		query.append("and    x.delt_flg    = 'N'" ).append("\n"); 
		query.append("and    rownum = 1" ).append("\n"); 
		query.append("),'') as bzet_addr," ).append("\n"); 
		query.append("a.delt_flg" ).append("\n"); 
		query.append("from   joo_carrier  a," ).append("\n"); 
		query.append("mdm_vendor   b," ).append("\n"); 
		query.append("mdm_customer c" ).append("\n"); 
		query.append("where  a.vndr_seq    = b.vndr_seq   (+)" ).append("\n"); 
		query.append("and    a.cust_cnt_cd = c.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and    a.cust_seq    = c.cust_seq   (+)" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!='')" ).append("\n"); 
		query.append("and    a.jo_crr_cd   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("and    a.trd_cd      = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!='')" ).append("\n"); 
		query.append("and    a.rlane_cd    = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg}!='')" ).append("\n"); 
		query.append("and    a.delt_flg    = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order  by 1,2,3" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOVndrCustListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}