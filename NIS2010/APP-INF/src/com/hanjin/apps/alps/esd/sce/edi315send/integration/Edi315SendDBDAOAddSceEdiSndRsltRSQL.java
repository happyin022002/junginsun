/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceEdiSndRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.18 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceEdiSndRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceEdiSndRslt
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceEdiSndRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceEdiSndRsltRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("''edi_grp_cd," ).append("\n"); 
		query.append("''edi_sts_cd," ).append("\n"); 
		query.append("''edi_sub_sts_cd," ).append("\n"); 
		query.append("''bkg_no," ).append("\n"); 
		query.append("''cntr_no," ).append("\n"); 
		query.append("''po_no," ).append("\n"); 
		query.append("''edi_snd_knt," ).append("\n"); 
		query.append("''bl_no," ).append("\n"); 
		query.append("''nod_cd," ).append("\n"); 
		query.append("''act_dt," ).append("\n"); 
		query.append("''man_flg," ).append("\n"); 
		query.append("''edi_snd_rmk," ).append("\n"); 
		query.append("''edi_snd_tp_cd," ).append("\n"); 
		query.append("''cre_usr_id," ).append("\n"); 
		query.append("''cre_dt," ).append("\n"); 
		query.append("''upd_usr_id," ).append("\n"); 
		query.append("''upd_dt," ).append("\n"); 
		query.append("''edi_snd_yrmondy," ).append("\n"); 
		query.append("''edi_snd_seq," ).append("\n"); 
		query.append("''pkup_edi_322_no," ).append("\n"); 
		query.append("''edi_snd_rsv_dt," ).append("\n"); 
		query.append("''trunk_vvd," ).append("\n"); 
		query.append("''gmt_dt," ).append("\n"); 
		query.append("''flt_file_ref_no," ).append("\n"); 
		query.append("''rslt_flag," ).append("\n"); 
		query.append("''nod," ).append("\n"); 
		query.append("''edi_snd_itval_hr," ).append("\n"); 
		query.append("''cop_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}