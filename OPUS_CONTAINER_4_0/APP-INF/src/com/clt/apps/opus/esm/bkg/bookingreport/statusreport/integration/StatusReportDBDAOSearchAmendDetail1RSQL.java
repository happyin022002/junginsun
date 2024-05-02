/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOSearchAmendDetail1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.07 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchAmendDetail1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchAmendDetail1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchAmendDetail1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchAmendDetail1RSQL").append("\n"); 
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
		query.append("decode(sum(mis_tp),0,'0','I1')   AS MIS_TYP,     /* Mis-Typing */" ).append("\n"); 
		query.append("decode(sum(mis_sc),0,'0','R1')   AS MIS_RAT_SC,  /* Mis-Rating(S/C) */" ).append("\n"); 
		query.append("decode(sum(mis_rfa),0,'0','R2')  AS MIS_RAT_RFA, /* Mis-Rating(RFA) */" ).append("\n"); 
		query.append("decode(sum(wrong_in),0,'0','I2') AS WRO_DAT_INP, /* Wrong Data Input  */" ).append("\n"); 
		query.append("decode(sum(sales),0,'0','F1')    AS SAL,         /* Sales */" ).append("\n"); 
		query.append("decode(sum(fo_error),0,'0','F2') AS FO_ERR,      /* FO Error */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("decode(sum(data_mi),0,'0','DM')  AS DAT_MIS,      /* Data Missing */" ).append("\n"); 
		query.append("decode(sum(uncl_fax),0,'0','UF') AS UNC_FAX,      /* Unclear Fax */" ).append("\n"); 
		query.append("decode(sum(bl_chan),0,'0','BL')  AS BL_DAT_CHA,   /* B/L Data Change */" ).append("\n"); 
		query.append("decode(sum(cod),0,'0','CD')      AS COD,          /* COD */" ).append("\n"); 
		query.append("decode(sum(sp),0,'0','SP')       AS SPL           /* Split/Combine */" ).append("\n"); 
		query.append("FROM     ( select decode(amd_rsn,'I1',decode(SR_AMD_RSN_CD,null,0,1)) mis_tp," ).append("\n"); 
		query.append("decode(amd_rsn,'R1',decode(SR_AMD_RSN_CD,null,0,1)) mis_sc," ).append("\n"); 
		query.append("decode(amd_rsn,'R2',decode(SR_AMD_RSN_CD,null,0,1)) mis_rfa," ).append("\n"); 
		query.append("decode(amd_rsn,'I2',decode(SR_AMD_RSN_CD,null,0,1)) wrong_in," ).append("\n"); 
		query.append("decode(amd_rsn,'F1',decode(SR_AMD_RSN_CD,null,0,1)) sales," ).append("\n"); 
		query.append("decode(amd_rsn,'F2',decode(SR_AMD_RSN_CD,null,0,1)) fo_error," ).append("\n"); 
		query.append("decode(amd_rsn,'DM',decode(SR_AMD_RSN_CD,null,0,1)) data_mi," ).append("\n"); 
		query.append("decode(amd_rsn,'UF',decode(SR_AMD_RSN_CD,null,0,1)) uncl_fax," ).append("\n"); 
		query.append("decode(amd_rsn,'BL',decode(SR_AMD_RSN_CD,null,0,1)) bl_chan," ).append("\n"); 
		query.append("decode(amd_rsn,'CD',decode(SR_AMD_RSN_CD,null,0,1)) cod," ).append("\n"); 
		query.append("decode(amd_rsn,'SP',decode(SR_AMD_RSN_CD,null,0,1)) sp" ).append("\n"); 
		query.append("from      BKG_SR_AMD_RSN, (select 'I1' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'R1' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'R2' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'I2' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'F1' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'F2' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'DM' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'UF' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'BL' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'CD' amd_rsn from dual union all" ).append("\n"); 
		query.append("select 'SP' amd_rsn from dual) xx" ).append("\n"); 
		query.append("where  SR_AMD_RSN_CD(+) = xx.amd_rsn" ).append("\n"); 
		query.append("and     bkg_no(+) = @[bkg_no]" ).append("\n"); 
		query.append("and     sr_no(+) = @[sr_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}