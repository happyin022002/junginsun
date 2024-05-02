/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchEffectiveDateList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.07.01 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchEffectiveDateList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * traff 일자의 version을 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchEffectiveDateList2RSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select      t1. yd_chg_no  ," ).append("\n"); 
		query.append("decode(  upd_mnu_no , '1' ,   'TL_'  ||  t1.yd_chg_ver_seq ,  'SF_'  ||  t1.yd_chg_ver_seq  )  ver  ," ).append("\n"); 
		query.append("to_char(  eff_dt, 'YYYY-mm-dd') eff_dt ," ).append("\n"); 
		query.append("to_char(  exp_dt , 'YYYY-mm-dd')  exp_dt" ).append("\n"); 
		query.append("from pso_yd_chg t1,  pso_yd_chg_xpr t2 , pso_chg_xpr t3 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select  t2.acct_cd, t2.lgs_cost_cd, lgs_cost_full_nm" ).append("\n"); 
		query.append("from    pso_inv_ofc_cost t1, tes_lgs_cost t2" ).append("\n"); 
		query.append("where   t1.lgs_cost_cd = t2.lgs_cost_cd" ).append("\n"); 
		query.append("and     t1.ofc_cd      = @[ofc_cd]" ).append("\n"); 
		query.append("and     t2.acct_cd          <> '999999'" ).append("\n"); 
		query.append("and length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 
		query.append(") T4" ).append("\n"); 
		query.append("where  t1.yd_chg_no = t2.yd_chg_no" ).append("\n"); 
		query.append("and  t1.yd_chg_ver_seq = t2.yd_chg_ver_seq" ).append("\n"); 
		query.append("and t2.chg_xpr_no = t3.chg_xpr_no" ).append("\n"); 
		query.append("AND t1.LGS_COST_CD      = T4.lgs_cost_cd" ).append("\n"); 
		query.append("AND  YD_CD            = @[combo1]" ).append("\n"); 
		query.append("AND  VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("AND  T4.acct_cd       = @[acct_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchEffectiveDateList2RSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}