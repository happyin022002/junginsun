/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchCargoTrackingDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.01.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchCargoTrackingDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCargoTrackingData
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchCargoTrackingDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration ").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchCargoTrackingDataRSQL").append("\n"); 
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
		query.append("select  rownum, edi_sub_sts_cd cust_sts," ).append("\n"); 
		query.append("nod_cd nod," ).append("\n"); 
		query.append("to_char(act_dt,'yyyymmdd') act_dt_day," ).append("\n"); 
		query.append("to_char(act_dt, 'hh24:mi:ss') act_dt_hour," ).append("\n"); 
		query.append("to_char(cre_dt,'yyyy/mm/dd hh24:mi:ss') edi_prc_dt," ).append("\n"); 
		query.append("--20071129           case when edi_snd_tp_cd = 'Y' and edi_snd_rmk like 'SUCCESS%' then" ).append("\n"); 
		query.append("--20071129                to_char(upd_dt,'yyyy/mm/dd hh24:mi:ss')" ).append("\n"); 
		query.append("--20071129                else" ).append("\n"); 
		query.append("--20071129                null" ).append("\n"); 
		query.append("--20071129                end," ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("case when edi_snd_tp_cd in ('Y', 'L') and edi_snd_rmk is not null then     --20071129 LocalTime" ).append("\n"); 
		query.append("to_char(gmt_dt,'yyyy/mm/dd hh24:mi:ss')" ).append("\n"); 
		query.append("else" ).append("\n"); 
		query.append("null" ).append("\n"); 
		query.append("end edi_prc_dt2," ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("upd_usr_id upd_by ," ).append("\n"); 
		query.append("case when edi_snd_tp_cd = 'Y' and edi_snd_rmk is not null then" ).append("\n"); 
		query.append("edi_snd_rmk" ).append("\n"); 
		query.append("when edi_snd_tp_cd = 'Y' and edi_snd_rmk is null then" ).append("\n"); 
		query.append("'SEND FAILED'" ).append("\n"); 
		query.append("when edi_snd_tp_cd = 'L' then" ).append("\n"); 
		query.append("'SAVED'" ).append("\n"); 
		query.append("else edi_snd_rmk" ).append("\n"); 
		query.append("end   rslt," ).append("\n"); 
		query.append("flt_file_ref_no" ).append("\n"); 
		query.append("from sce_edi_snd_rslt" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("and bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("and cntr_no     = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${edi_sts} != '')" ).append("\n"); 
		query.append("and edi_sts_cd  = @[edi_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${edi_grp_cd} != '')" ).append("\n"); 
		query.append("and edi_grp_cd  = @[edi_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--20071214History order by act_dt" ).append("\n"); 
		query.append("order by edi_snd_knt" ).append("\n"); 

	}
}