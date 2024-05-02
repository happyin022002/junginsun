/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAORemovePsoYdChgXprByChgNoChgVerTpCdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.30 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAORemovePsoYdChgXprByChgNoChgVerTpCdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG_XPR <delete By YD_CHG_NO, YD_CHG_VER_SEQ, PSO_CHG_TP_CD>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAORemovePsoYdChgXprByChgNoChgVerTpCdDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("charge_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAORemovePsoYdChgXprByChgNoChgVerTpCdDSQL").append("\n"); 
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
		query.append("DELETE PSO_YD_CHG_XPR X" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    X.YD_CHG_XPR_NO IN (" ).append("\n"); 
		query.append("SELECT B.YD_CHG_XPR_NO" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG A" ).append("\n"); 
		query.append(",PSO_YD_CHG_XPR B" ).append("\n"); 
		query.append("WHERE  A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("AND    A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("AND    A.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("AND    A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("AND    B.PSO_CHG_TP_CD = DECODE(@[charge_type], 'ALL', B.PSO_CHG_TP_CD, @[charge_type]) --Base, Surcharge, Discount" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}