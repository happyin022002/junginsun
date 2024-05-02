/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchAgreementCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchAgreementCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Lgs Cost Code, Flag 정보 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchAgreementCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_cy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_mrn_tml_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_rail_rmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_cfs_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchAgreementCostRSQL").append("\n"); 
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
		query.append("SELECT	a.lgs_cost_cd, c.tml_agmt_div_flg" ).append("\n"); 
		query.append("FROM	TES_LGS_COST a, TES_TML_AGMT_COST b, TES_TML_AGMT_VRFY_MZD c" ).append("\n"); 
		query.append("WHERE	a.lgs_cost_cd	= b.lgs_cost_cd" ).append("\n"); 
		query.append("AND		a.lgs_cost_cd	= c.lgs_cost_cd	" ).append("\n"); 
		query.append("AND     a.lgs_cost_cd not in ('SRNDCH','SRNDGS','SRFDCH','SRFDGS')															" ).append("\n"); 
		query.append("AND		(DECODE(@[yd_chr_cd]||@[yd_fcty_tp_mrn_tml_flg]||@[yd_fcty_tp_cy_flg]," ).append("\n"); 
		query.append("								'NYY', b.mrn_tml_flg," ).append("\n"); 
		query.append("								'NYN', b.mrn_tml_flg," ).append("\n"); 
		query.append("								'FYY', b.fdck_cy_flg," ).append("\n"); 
		query.append("								'FNY', b.fdck_cy_flg ) = 'Y'" ).append("\n"); 
		query.append("OR		b.cfs_flg		IN (DECODE(@[yd_fcty_tp_cfs_flg],'N','N','Y'),'N')" ).append("\n"); 
		query.append("OR		b.rail_rmp_flg	IN (DECODE(@[yd_fcty_tp_rail_rmp_flg],'N','N','Y'),'N'))" ).append("\n"); 
		query.append("ORDER BY a.lgs_cost_cd" ).append("\n"); 

	}
}