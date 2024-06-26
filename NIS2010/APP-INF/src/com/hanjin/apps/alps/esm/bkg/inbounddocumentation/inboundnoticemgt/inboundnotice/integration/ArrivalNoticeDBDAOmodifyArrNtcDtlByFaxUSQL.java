/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOmodifyArrNtcDtlByFaxUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2009.12.23 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOmodifyArrNtcDtlByFaxUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [0381] Detail 수정, Fax 관련정보만 수정
	  * </pre>
	  */
	public ArrivalNoticeDBDAOmodifyArrNtcDtlByFaxUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOmodifyArrNtcDtlByFaxUSQL").append("\n"); 
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
		query.append("UPDATE BKG_ARR_NTC_DTL" ).append("\n"); 
		query.append("SET FAX_NO              = @[fax_no]" ).append("\n"); 
		query.append(",FAX_SND_DT          = NULL" ).append("\n"); 
		query.append(",FAX_SND_GDT         = NULL" ).append("\n"); 
		query.append(",FAX_NTC_SND_RSLT_CD = NULL" ).append("\n"); 
		query.append(",FAX_SND_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append(",UPD_USR_ID          = @[usr_id]" ).append("\n"); 
		query.append(",UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD    = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("AND CUST_CNTC_TP_CD   = @[cust_cntc_tp_cd]" ).append("\n"); 

	}
}