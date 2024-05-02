/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PortTariffMgtDBDAOModifyPsoYdChgCplsFlgByNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.31
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.31 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtDBDAOModifyPsoYdChgCplsFlgByNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG CPLS_FLG를 수정한다.
	  * 
	  * ------------------------------------------------
	  * History
	  * 2011.10.31 진마리아 선처리(SRM-201121014) [VOP-PSO] Tariff Value Management 화면 로직 변경
	  * </pre>
	  */
	public PortTariffMgtDBDAOModifyPsoYdChgCplsFlgByNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cpls_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtDBDAOModifyPsoYdChgCplsFlgByNoUSQL").append("\n"); 
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
		query.append("UPDATE PSO_YD_CHG A" ).append("\n"); 
		query.append("SET    A.CPLS_FLG = NVL2(@[cpls_flg]" ).append("\n"); 
		query.append("                        ,DECODE(A.YD_CHG_VER_SEQ, @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("                               ,CASE WHEN @[cpls_flg] IN ('Y','N') THEN @[cpls_flg]" ).append("\n"); 
		query.append("                                     ELSE DECODE(@[cpls_flg], 0, 'N', 1, 'Y')" ).append("\n"); 
		query.append("                                END     " ).append("\n"); 
		query.append("                               ,A.CPLS_FLG)" ).append("\n"); 
		query.append("                        ,A.CPLS_FLG) " ).append("\n"); 
		query.append("WHERE  A.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("  AND  A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 

	}
}