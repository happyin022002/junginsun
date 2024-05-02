/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCheckCustSrepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCheckCustSrepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SHPR와 FWDR의 담당SREP의 일치여부를 확인한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCheckCustSrepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCheckCustSrepRSQL").append("\n"); 
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
		query.append("select count(1) CNT" ).append("\n"); 
		query.append("  from (" ).append("\n"); 
		query.append("        select cust.srep_cd," ).append("\n"); 
		query.append("               '1' sort" ).append("\n"); 
		query.append("          from mdm_customer cust," ).append("\n"); 
		query.append("               mdm_sls_rep sls" ).append("\n"); 
		query.append("         where (" ).append("\n"); 
		query.append("                (cust.cust_cnt_cd = @[s_cust_cnt_cd] and cust.cust_seq = @[s_cust_seq])" ).append("\n"); 
		query.append("                OR " ).append("\n"); 
		query.append("				(substr(@[f_cust_cnt_cd], 1, 2) <> 'US' and cust.cust_cnt_cd = @[f_cust_cnt_cd] and cust.cust_seq = @[f_cust_seq])" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           and cust.delt_flg = 'N'" ).append("\n"); 
		query.append("           and cust.srep_cd = sls.srep_cd" ).append("\n"); 
		query.append("           and sls.srep_sts_cd = 'N'" ).append("\n"); 
		query.append("           and cust.srep_cd = @[ob_srep_cd]" ).append("\n"); 
		query.append("     union all " ).append("\n"); 
		query.append("        select cust.srep_cd," ).append("\n"); 
		query.append("               '2' sort" ).append("\n"); 
		query.append("          from bkg_cust_sls_rep cust," ).append("\n"); 
		query.append("               mdm_customer mdm_cust," ).append("\n"); 
		query.append("               mdm_sls_rep sls" ).append("\n"); 
		query.append("         where (" ).append("\n"); 
		query.append("                (cust.cust_cnt_cd = @[s_cust_cnt_cd] and cust.cust_seq = @[s_cust_seq])" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append(" 				(substr(@[f_cust_cnt_cd], 1, 2) <> 'US' and cust.cust_cnt_cd = @[f_cust_cnt_cd] and cust.cust_seq = @[f_cust_seq])" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("           and cust.delt_flg    = 'N'" ).append("\n"); 
		query.append("           and mdm_cust.delt_flg = 'N'" ).append("\n"); 
		query.append("           and cust.cust_cnt_cd = mdm_cust.cust_cnt_cd" ).append("\n"); 
		query.append("           and cust.cust_seq    = mdm_cust.cust_seq" ).append("\n"); 
		query.append("           and cust.srep_cd     <> mdm_cust.srep_cd" ).append("\n"); 
		query.append("           and cust.srep_cd = sls.srep_cd" ).append("\n"); 
		query.append("           and sls.srep_sts_cd = 'N'" ).append("\n"); 
		query.append("           and cust.srep_cd = @[ob_srep_cd]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}