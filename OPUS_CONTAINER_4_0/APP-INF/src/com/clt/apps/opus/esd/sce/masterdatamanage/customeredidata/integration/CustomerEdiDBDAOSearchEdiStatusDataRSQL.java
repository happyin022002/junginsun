/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEdiStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2011.03.09 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeYoonJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEdiStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiStatusDataRSQL
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEdiStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hj_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchEdiStatusDataRSQL").append("\n"); 
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
		query.append("rownum" ).append("\n"); 
		query.append(", grp.edi_grp_cd  edi_grp_cd" ).append("\n"); 
		query.append(", grp.edi_grp_desc edi_grp_desc" ).append("\n"); 
		query.append(", grp.cust_trd_prnr_id cust_trd_prnr_id" ).append("\n"); 
		query.append(", grp.prov_trd_prnr_id prov_trd_prnr_id" ).append("\n"); 
		query.append(", cgo.edi_stnd_sts_cd edi_stnd_sts_cd" ).append("\n"); 
		query.append(", sts.edi_sts_desc edi_sts_desc" ).append("\n"); 
		query.append(", decode(cgo.edi_snd_flg,'Y','YES','N','NO','M','Manual') edi_snd_flg" ).append("\n"); 
		query.append(", decode(cgo.edi_vsl_tp_cd,1,'Trunk',2,'Not Trunk',3,'All') edi_vsl_tp_cd" ).append("\n"); 
		query.append(", decode(cgo.edi_evnt_cd,1,'First',2,'Not first',3,'Last',4,'Not last',5,'All') edi_evnt_cd" ).append("\n"); 
		query.append(", cgo.EDI_SND_ITVAL_HRMNT EDI_SND_ITVAL_HRMNT" ).append("\n"); 
		query.append(", decode(cgo.EDI_CNTR_SND_TP_CD,'C','CNTR','B','B/L','') EDI_CNTR_SND_TP_CD" ).append("\n"); 
		query.append(", cgo.cust_edi_sts_cd cust_edi_sts_cd" ).append("\n"); 
		query.append("from edi_group grp, edi_grp_cgo cgo, edi_cgo_stnd_sts sts" ).append("\n"); 
		query.append("where grp.edi_grp_cd = cgo.edi_grp_cd" ).append("\n"); 
		query.append("and grp.co_div_cd = cgo.co_div_cd" ).append("\n"); 
		query.append("and cgo.co_div_cd = sts.co_div_cd" ).append("\n"); 
		query.append("and cgo.edi_stnd_sts_cd = sts.edi_stnd_sts_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cs_grp_id} != '')" ).append("\n"); 
		query.append("and grp.edi_grp_cd  = @[cs_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cs_tp_id} != '')" ).append("\n"); 
		query.append("and grp.cust_trd_prnr_id = @[cs_tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hj_tp_id} != '')" ).append("\n"); 
		query.append("and grp.prov_trd_prnr_id = @[hj_tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cs_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and grp.edi_grp_cd  in (select edi_grp_cd" ).append("\n"); 
		query.append("from  edi_grp_cust" ).append("\n"); 
		query.append("where (cust_cnt_cd || cust_seq) = @[cs_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and grp.edi_grp_cd  in (select edi_grp_cd" ).append("\n"); 
		query.append("from  edi_grp_cust" ).append("\n"); 
		query.append("where sc_no =     @[sc_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}