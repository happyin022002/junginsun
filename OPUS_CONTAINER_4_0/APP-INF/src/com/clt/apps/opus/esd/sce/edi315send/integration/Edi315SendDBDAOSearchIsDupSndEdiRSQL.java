/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsDupSndEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.10 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIsDupSndEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchIsDupSndEdiRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsDupSndEdiRSQL(){
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
		params.put("e_evnet_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_log_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_event_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cust_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_group_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIsDupSndEdiRSQL").append("\n"); 
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
		query.append("SELECT  /*+ index_desc(SCE_EDI_SND_RSLT XPKSCE_EDI_SND_RSLT) */" ).append("\n"); 
		query.append("nvl(to_char(ACT_DT,'YYYYMMDDHH24MISS'), 'N/A')" ).append("\n"); 
		query.append("FROM    SCE_EDI_SND_RSLT" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     EDI_GRP_CD              = @[e_edi_group_cd]" ).append("\n"); 
		query.append("AND     EDI_STS_CD              = @[e_edi_sts]" ).append("\n"); 
		query.append("AND     EDI_SUB_STS_CD          = @[e_cust_edi_sts_cd]" ).append("\n"); 
		query.append("AND     BKG_NO                  = @[e_bkg_no]" ).append("\n"); 
		query.append("AND     CNTR_NO                 = @[e_cntr_no]" ).append("\n"); 
		query.append("and     substr(NOD_CD, 1, 5)    = substr(@[e_evnet_yard], 1, 5)" ).append("\n"); 
		query.append("and     (" ).append("\n"); 
		query.append("(@[e_log_flg] = 'N' and ACT_DT = to_date(@[e_event_dt], 'yyyymmddhh24miss'))" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("(@[e_log_flg] = 'Y')" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("(@[e_edi_sts] = 'VE')-- VE 일땐 무조건 최근 발송된 ACT_DT Return. 로직이 따로 존재 함." ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and     ROWNUM = 1" ).append("\n"); 

	}
}