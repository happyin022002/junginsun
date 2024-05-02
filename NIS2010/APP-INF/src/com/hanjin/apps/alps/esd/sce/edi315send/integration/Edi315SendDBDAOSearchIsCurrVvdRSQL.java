/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsCurrVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.10 
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

public class Edi315SendDBDAOSearchIsCurrVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchIsCurrVvdRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsCurrVvdRSQL(){
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
		query.append("FileName : Edi315SendDBDAOSearchIsCurrVvdRSQL").append("\n"); 
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
		query.append("--   d.nod_cd                                                  curr_nod" ).append("\n"); 
		query.append("-- ,d.cop_dtl_seq                                             curr_cop_dtl_seq" ).append("\n"); 
		query.append("-- ,to_char(d.estm_dt,'YYYYMMDDHH24MISS') 			   	     curr_estm_dt" ).append("\n"); 
		query.append("-- ,to_char(d.act_dt,'YYYYMMDDHH24MISS') 				     curr_act_dt" ).append("\n"); 
		query.append("bound                                                     curr_bound" ).append("\n"); 
		query.append(",d.vsl_cd||d.skd_voy_no||d.skd_dir_cd                      curr_vvd" ).append("\n"); 
		query.append(",replace(mv.vsl_eng_nm, chr(39), ' ')                      vsl_nm" ).append("\n"); 
		query.append(",mv.vsl_rgst_cnt_cd                                        vsl_cnt_cd" ).append("\n"); 
		query.append(",nvl(decode(mv.LLOYD_NO, 'T.B.N.', 'TBN', 'T.B.N', 'TBN', LLOYD_NO), ' ')  lloyd_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",ml.LOC_NM                                                 rly_name" ).append("\n"); 
		query.append(",ml.LOC_CD                                                 rly_port" ).append("\n"); 
		query.append(",DECODE(ml.CNT_CD, 'US', 'D', 'K')                         rly_amsqual" ).append("\n"); 
		query.append(",ml.LOC_AMS_PORT_CD                                        rly_amsport" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SCE_COP_DTL D, MDM_VSL_CNTR MV, MDM_LOCATION ML," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT case when  EDI_STS_SEQ <= 200 or  @[e_edi_sts] in ('BF', 'AW', 'AMO') then 'OB'" ).append("\n"); 
		query.append("when (EDI_STS_SEQ >  200 and EDI_STS_SEQ < 300 and @[e_edi_sts] <> 'VE') or @[e_edi_sts] in ('UVD') then 'OC'" ).append("\n"); 
		query.append("when (EDI_STS_SEQ >= 300 and @[e_edi_sts] not in ('BF', 'AW', 'AMO', 'UVD')) or @[e_edi_sts] = 'VE' then 'IB'" ).append("\n"); 
		query.append("END BOUND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from EDI_CGO_STND_STS" ).append("\n"); 
		query.append("where EDI_STND_STS_CD = @[e_edi_sts]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where cop_no  = @[e_cop_no]" ).append("\n"); 
		query.append("and (" ).append("\n"); 
		query.append("('OB' = BOUND and act_cd like 'FL%')" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("('OC' = BOUND and nod_cd like @[e_event_yard]  and STND_EDI_STS_CD like decode(@[e_edi_sts], 'VE', 'VA%', @[e_edi_sts]||'%'))" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("('IB' = BOUND and act_cd like 'FU%')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and mv.VSL_CD = d.VSL_CD" ).append("\n"); 
		query.append("and ml.LOC_CD = SUBSTR(nod_cd,1,5)" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}