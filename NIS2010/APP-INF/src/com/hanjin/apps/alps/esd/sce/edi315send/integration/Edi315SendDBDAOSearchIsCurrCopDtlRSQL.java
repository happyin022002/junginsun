/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsCurrCopDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIsCurrCopDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchIsCurrCopDtlRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsCurrCopDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIsCurrCopDtlRSQL").append("\n"); 
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
		query.append("select  " ).append("\n"); 
		query.append("      #if(${e_edi_sts} == 'VE' && ${e_org_sts} =='VAT' && ${e_edi_grpcd} =='EUR00190')" ).append("\n"); 
		query.append("        to_char(d.ACT_DT,'yyyymmddhh24miss') CURR_EVENT_DT" ).append("\n"); 
		query.append("      #elseif(${e_edi_sts} == 'VBE' && ${e_org_sts} =='VDL' && " ).append("\n"); 
		query.append("         (${e_edi_grpcd} =='COM02218' || ${e_edi_grpcd} =='USA00512' || ${e_edi_grpcd} =='USA00607' || ${e_edi_grpcd} =='USA00094'))" ).append("\n"); 
		query.append("		to_char(d.ESTM_DT,'yyyymmddhh24miss') CURR_EVENT_DT" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        to_char(DECODE(@[e_edi_sts] ,'VE',d.ESTM_DT,'AG',d.ESTM_DT ,'AD',d.ESTM_DT,d.ACT_DT),'yyyymmddhh24miss') CURR_EVENT_DT" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      , d.NOD_CD                                      CURR_EVENT_YARD" ).append("\n"); 
		query.append("      , d.COP_DTL_SEQ                                 CURR_COP_DTL_SEQ" ).append("\n"); 
		query.append("	  ,'' CURR_STS" ).append("\n"); 
		query.append("from sce_cop_dtl d, sce_cop_hdr h, bkg_booking b " ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and  d.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append("and  d.cop_no = h.cop_no" ).append("\n"); 
		query.append("and  h.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("#if(${e_edi_sts} == 'AG' || ${e_edi_sts} == 'AD')" ).append("\n"); 
		query.append("AND d.act_cd = 'FITZAD'  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" #if(${e_edi_sts} == 'VE' && ${e_org_sts} =='VAT' && ${e_edi_grpcd} =='EUR00190')" ).append("\n"); 
		query.append("and (d.STND_EDI_STS_CD = DECODE(@[e_edi_sts] ,'VE','VAT',@[e_edi_sts])" ).append("\n"); 
		query.append(" #elseif(${e_edi_sts} == 'VBE' && ${e_org_sts} =='VDL' && " ).append("\n"); 
		query.append("    (${e_edi_grpcd} =='COM02218' || ${e_edi_grpcd} =='USA00512' || ${e_edi_grpcd} =='USA00607' || ${e_edi_grpcd} =='USA00094'))" ).append("\n"); 
		query.append("and (d.STND_EDI_STS_CD = DECODE(@[e_edi_sts] ,'VBE','VBD',@[e_edi_sts])" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("and (d.STND_EDI_STS_CD = DECODE(@[e_edi_sts] ,'VE','VAD',@[e_edi_sts])" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("  or d.ACT_CD = @[e_edi_sts]" ).append("\n"); 
		query.append("  or d.ACT_STS_MAPG_CD = @[e_edi_sts]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  d.NOD_CD = DECODE(@[e_edi_sts] ,'VE',d.NOD_CD" ).append("\n"); 
		query.append("									,'AG',d.NOD_CD" ).append("\n"); 
		query.append("									,'AD',d.NOD_CD" ).append("\n"); 
		query.append("									,'VBE',d.NOD_CD" ).append("\n"); 
		query.append("					  ,@[e_event_yard])" ).append("\n"); 

	}
}