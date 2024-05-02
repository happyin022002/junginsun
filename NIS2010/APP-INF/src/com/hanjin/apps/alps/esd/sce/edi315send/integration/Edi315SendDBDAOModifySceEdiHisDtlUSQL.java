/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOModifySceEdiHisDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.04.08 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOModifySceEdiHisDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for updating SCE_EDI_HIS_DTL
	  * </pre>
	  */
	public Edi315SendDBDAOModifySceEdiHisDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rslt_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rslt_remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rcv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOModifySceEdiHisDtlUSQL").append("\n"); 
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
		query.append("UPDATE SCE_EDI_HIS_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("RSLT_FLG = @[e_rslt_flag]," ).append("\n"); 
		query.append("EDI_SND_RSLT_RMK =" ).append("\n"); 
		query.append("nvl(@[e_rslt_remark]" ).append("\n"); 
		query.append(",decode(@[e_rslt_flag]" ).append("\n"); 
		query.append(", 'Y', 'SUCCESS(SENT)'" ).append("\n"); 
		query.append(", 'K', 'SUCCESS(AMS SAVED)'" ).append("\n"); 
		query.append(", 'L', 'SAVED'" ).append("\n"); 
		query.append(", 'F', 'FAILED'" ).append("\n"); 
		query.append(", 'R', 'RESERVED'" ).append("\n"); 
		query.append(", 'S', 'Send Process Skip.'" ).append("\n"); 
		query.append(", ''))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE EDI_RCV_DT     = @[e_rcv_dt]" ).append("\n"); 
		query.append("AND EDI_RCV_SEQ      = to_number(@[e_rcv_seq])" ).append("\n"); 
		query.append("AND EDI_RCV_DTL_SEQ  = to_number(@[e_rcv_dtl_seq])" ).append("\n"); 

	}
}