/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOModifyChgXprDescByChgXprNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.01.07 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOModifyChgXprDescByChgXprNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOModifyChgXprDescByChgXprNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOModifyChgXprDescByChgXprNoUSQL").append("\n"); 
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
		query.append("UPDATE PSO_CHG_XPR A SET" ).append("\n"); 
		query.append("A.XPR_DESC              = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 1)" ).append("\n"); 
		query.append(",A.DFLT_XPR_DESC         = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 2)" ).append("\n"); 
		query.append(",A.SYS_XPR_DESC          = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 3)" ).append("\n"); 
		query.append(",A.SYS_XPR_USR_DESC      = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 4)" ).append("\n"); 
		query.append(",A.SYS_XPR_VAL_DESC      = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 5)" ).append("\n"); 
		query.append(",A.DFLT_SYS_XPR_DESC     = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 6)" ).append("\n"); 
		query.append(",A.DFLT_SYS_XPR_USR_DESC = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 7)" ).append("\n"); 
		query.append(",A.DFLT_SYS_XPR_VAL_DESC = PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 8)" ).append("\n"); 
		query.append(",A.UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.CHG_XPR_NO = @[chg_xpr_no]" ).append("\n"); 
		query.append("AND    PSO_STMT_CHK_FNC(PSO_GET_XPR_DESC_FNC(@[chg_xpr_no], 3), 3) = 'Y'	--XPR_DESC Validation" ).append("\n"); 

	}
}