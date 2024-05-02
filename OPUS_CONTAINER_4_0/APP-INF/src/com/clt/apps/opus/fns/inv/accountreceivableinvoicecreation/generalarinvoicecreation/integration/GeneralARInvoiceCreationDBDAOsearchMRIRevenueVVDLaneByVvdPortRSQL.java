/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.11.11 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneByVvdPortRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneByVvdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneByVvdPortRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR(AA,4,5),'') rev_lane, NVL(SUBSTR(AA,9),'') rev_vvd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(SUBSTR(TO_CHAR( n.rnk_seq ,'999'),2)||n.rlane_cd||q.vsl||q.voy_no||q.dep) AA" ).append("\n"); 
		query.append("FROM ar_rout_rnk n," ).append("\n"); 
		query.append("(  SELECT  v.rlane_cd rev_lane,  t.vsl, t.voy_no, t.dep, t.lane, t.sconti_cd, t.zone_ioc" ).append("\n"); 
		query.append("FROM ar_mst_rev_vvd v," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT b.vsl, b.voy_no, NVL(c.slan_dir_cd||c.rlane_dir_cd ,b.dep||b.dep) dep," ).append("\n"); 
		query.append("DECODE(b.vsl, 'COMC','COM','CNTC','CNT', DECODE(b.lane,'SYS','RBC',b.lane) ) lane, b.sconti_cd, b.zone_ioc" ).append("\n"); 
		query.append("FROM ar_finc_dir_conv c ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select lane, vsl, voy_no, dep, pol, pod, sconti_cd, zone_ioc" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select lane, vsl, voy_no, dep, pol, pod, MIN(sconti_cd)sconti_cd," ).append("\n"); 
		query.append("DECODE(MIN(pol_conti)||MIN(pod_conti), 'AA','IA', 'EE','IE','MM','IM','EF','IE','FE','IE','FF','IE','OO') zone_ioc" ).append("\n"); 
		query.append("from        (" ).append("\n"); 
		query.append("SELECT @[lane] lane, @[vsl] vsl, @[voy] voy_no, @[dep] dep," ).append("\n"); 
		query.append("@[pol] pol, @[pod] pod, conti_cd pol_conti, NULL pod_conti, sconti_cd" ).append("\n"); 
		query.append("FROM MDM_LOCATION l" ).append("\n"); 
		query.append("WHERE l.loc_cd = @[pol]" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT @[lane] lane, @[vsl] vsl, @[voy] voy_no, @[dep] dep," ).append("\n"); 
		query.append("@[pol] pol, @[pod] pod, NULL pol_conti, conti_cd pod_conti, sconti_cd" ).append("\n"); 
		query.append("FROM MDM_LOCATION l" ).append("\n"); 
		query.append("WHERE l.loc_cd = @[pod]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("group by lane, vsl, voy_no, dep, pol, pod )" ).append("\n"); 
		query.append("where sconti_cd is not null" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append("WHERE  c.slan_cd(+) = b.lane" ).append("\n"); 
		query.append("AND  c.slan_dir_cd(+) = b.dep" ).append("\n"); 
		query.append("--AND  c.    c.DCM_AP_MK(+) <> 'Y'" ).append("\n"); 
		query.append("AND  c.sconti_cd(+) = b.sconti_cd )t" ).append("\n"); 
		query.append("WHERE v.vsl_cd = t.vsl" ).append("\n"); 
		query.append("AND   v.skd_voy_no = t.voy_no" ).append("\n"); 
		query.append("AND   v.skd_dir_cd||v.rlane_dir_cd  = t.dep ) q" ).append("\n"); 
		query.append("WHERE n.rlane_cd = q.rev_lane" ).append("\n"); 
		query.append("AND   n.slan_cd = q.lane" ).append("\n"); 
		query.append("AND   substr(n.zn_ioc_cd,1,2) = q.zone_ioc )" ).append("\n"); 

	}
}