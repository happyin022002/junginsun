/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOJooSettlementVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOJooSettlementVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOJooSettlementVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_scg_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOJooSettlementVODSQL").append("\n"); 
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
		query.append("DELETE JOO_SETTLEMENT" ).append("\n"); 
		query.append("WHERE ACCT_YRMON       = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND	  STL_VVD_SEQ      = TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("#if ( ${jo_stl_itm_cd} == 'R/F' && ${jo_mnu_nm} == 'R/F' )" ).append("\n"); 
		query.append("--2010.03.03 발견" ).append("\n"); 
		query.append("--R/F는 20FT, 40FT를 횡으로 보여주므로 만약 같은 조건의 20FT가  2건 이상이라면 MIN(DECODE(JO_STL_JB_CD,'301',STL_SEQ))에 의해 MIN STL_SEQ만 삭제되는 문제가 발생" ).append("\n"); 
		query.append("--그러나 아래 QUERY도 이행DATA가 아래 조건항목중 NULL인 것이 있으면 삭제 안되는 문제 발생함" ).append("\n"); 
		query.append("--양쪽에 NVL처리" ).append("\n"); 
		query.append("AND   NVL(JO_CRR_CD       ,'') = NVL(@[jo_crr_cd]       ,'')" ).append("\n"); 
		query.append("AND   NVL(TRD_CD          ,'') = NVL(@[trd_cd]          ,'')" ).append("\n"); 
		query.append("AND   NVL(RLANE_CD        ,'') = NVL(@[rlane_cd]        ,'')" ).append("\n"); 
		query.append("AND   NVL(RE_DIVR_CD      ,'') = NVL(@[re_divr_cd]      ,'')" ).append("\n"); 
		query.append("AND	  NVL(JO_STL_ITM_CD   ,'') = NVL(@[jo_stl_itm_cd]   ,'')" ).append("\n"); 
		query.append("AND   NVL(JO_MNU_NM       ,'') = NVL(@[jo_mnu_nm]       ,'')" ).append("\n"); 
		query.append("AND   NVL(RF_SCG_STL_TP_CD,'') = NVL(@[rf_scg_stl_tp_cd],'')" ).append("\n"); 
		query.append("AND   NVL(IOC_CD          ,'') = NVL(@[ioc_cd]          ,'')" ).append("\n"); 
		query.append("AND   NVL(SCONTI_CD       ,'') = NVL(@[sconti_cd]       ,'')" ).append("\n"); 
		query.append("AND   NVL(FM_PORT_CD      ,'') = NVL(@[fm_port_cd]      ,'')" ).append("\n"); 
		query.append("AND   NVL(TO_PORT_CD      ,'') = NVL(@[to_port_cd]      ,'')" ).append("\n"); 
		query.append("AND	  STL_SEQ          = TO_NUMBER(@[stl_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	  STL_SEQ          = TO_NUMBER(@[stl_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}