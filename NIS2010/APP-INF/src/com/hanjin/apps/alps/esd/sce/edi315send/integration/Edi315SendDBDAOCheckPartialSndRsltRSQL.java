/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOCheckPartialSndRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.13
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.10.13 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOCheckPartialSndRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_edi_snd_rslt 를 조회하여 현재 발송 대상 bkg, cntr_no, edi_sts_cd 로 발송된 partial bkg 이 존재하는지 확인
	  * </pre>
	  */
	public Edi315SendDBDAOCheckPartialSndRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOCheckPartialSndRsltRSQL").append("\n"); 
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
		query.append("select '1' from sce_edi_snd_rslt where (bkg_no, cntr_no) in (" ).append("\n"); 
		query.append("select bkg_no, cntr_no" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where (cntr_no, trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd) in (" ).append("\n"); 
		query.append("select cntr_no, trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and bkg_no != @[bkg_no]" ).append("\n"); 
		query.append("and cop_sts_cd != 'X'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and edi_sts_cd = @[edi_sts]" ).append("\n"); 
		query.append("and edi_grp_cd = @[edi_grp_cd]" ).append("\n"); 
		query.append("and upper(edi_snd_rmk) = 'SUCCESS(SENT)'" ).append("\n"); 

	}
}