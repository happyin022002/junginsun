/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOGetVEVBEValidationCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
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

public class Edi315SendDBDAOGetVEVBEValidationCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VE, VBE 발송 시 VAD, VBD 전송 내역이 있으면 Block 처리
	  * </pre>
	  */
	public Edi315SendDBDAOGetVEVBEValidationCountRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetVEVBEValidationCountRSQL").append("\n"); 
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
		query.append("SELECT SIGN(COUNT(EDI_STS_CD)) CNT_SENT " ).append("\n"); 
		query.append("  FROM SCE_EDI_SND_RSLT A" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND BKG_NO= @[bkg_no] " ).append("\n"); 
		query.append("   AND CNTR_NO= @[cntr_no] " ).append("\n"); 
		query.append("   AND EDI_GRP_CD = @[edi_grp_cd] " ).append("\n"); 
		query.append("   #if (${edi_sts_cd} == 'VE')" ).append("\n"); 
		query.append("   AND EDI_STS_CD IN ('VAD')" ).append("\n"); 
		query.append("   #elseif (${edi_sts_cd} == 'VBE') " ).append("\n"); 
		query.append("   AND EDI_STS_CD IN ('VBD') " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND EDI_SND_RMK = 'SUCCESS(SENT)'" ).append("\n"); 

	}
}