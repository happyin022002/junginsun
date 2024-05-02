/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortGntrCrnVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	a.yd_cd" ).append("\n"); 
		query.append(",	b.yd_nm" ).append("\n"); 
		query.append(",	a.grs_max_wgt" ).append("\n"); 
		query.append(",	a.net_max_wgt" ).append("\n"); 
		query.append(",	a.clr_btwn_leg_wdt" ).append("\n"); 
		query.append(",	a.crn_rch_row_knt" ).append("\n"); 
		query.append(",	a.cntr_tr_knt" ).append("\n"); 
		query.append(",	a.ttl_gntr_crn_qty" ).append("\n"); 
		query.append(",	a.vsl_gntr_crn_max_qty" ).append("\n"); 
		query.append(",	a.gntr_rmk" ).append("\n"); 
		query.append(",	a.cre_usr_id" ).append("\n"); 
		query.append(",	a.upd_usr_id" ).append("\n"); 
		query.append(",	to_char(a.UPD_DT, 'YYYY-MM-DD HH24:MI') as UPD_DT" ).append("\n"); 
		query.append("FROM vsk_port_gntr_crn	a," ).append("\n"); 
		query.append("     mdm_yard b," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("              SELECT    MX.LOC_CD" ).append("\n"); 
		query.append("                     ,  (" ).append("\n"); 
		query.append("                        SELECT    MAX(DECODE(MO.OFC_TP_CD, 'HQ', MO.OFC_CD))--  AS VAL    " ).append("\n"); 
		query.append("                            FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                            CONNECT BY   NOCYCLE PRIOR MO.PRNT_OFC_CD  = MO.OFC_CD" ).append("\n"); 
		query.append("                            START WITH   MO.OFC_CD             = MX.SLS_OFC_CD" ).append("\n"); 
		query.append("                        ) AS POR_RHQ" ).append("\n"); 
		query.append("            FROM      MDM_LOCATION       MX " ).append("\n"); 
		query.append("          WHERE      MX.CALL_PORT_FLG    = 'Y'" ).append("\n"); 
		query.append("          AND        MX.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)c" ).append("\n"); 
		query.append("WHERE a.yd_cd = b.yd_cd" ).append("\n"); 
		query.append("AND  b.loc_cd = c.loc_cd" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND	b.loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_rhq} != '%') " ).append("\n"); 
		query.append("AND	c.por_rhq = @[por_rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY a.yd_cd" ).append("\n"); 

	}
}