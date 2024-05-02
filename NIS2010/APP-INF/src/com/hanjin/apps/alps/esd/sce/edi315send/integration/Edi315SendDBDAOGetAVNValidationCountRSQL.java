/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetAVNValidationCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 김진승
*@LastVersion : 1.0
* 2010.09.30 김진승
* 1.0 Creation
* 2010.09.30 김진승 [CHM-201006003-01] AVN 전송 Error Logic 보완
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

public class Edi315SendDBDAOGetAVNValidationCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAVNValidationCount
	  * </pre>
	  */
	public Edi315SendDBDAOGetAVNValidationCountRSQL(){
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
		query.append("FileName : Edi315SendDBDAOGetAVNValidationCountRSQL").append("\n"); 
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
		query.append("CNT_SENT * SIGN(CNT_FIN+CNT_CNMV) RESULT_INT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SIGN(COUNT(EDI_STS_CD)) CNT_SENT" ).append("\n"); 
		query.append("FROM SCE_EDI_SND_RSLT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO=@[cntr_no]" ).append("\n"); 
		query.append("AND EDI_GRP_CD = @[edi_grp_cd]" ).append("\n"); 
		query.append("AND EDI_STS_CD IN ('AVN','AVM')" ).append("\n"); 
		query.append("AND EDI_SND_RMK = 'SUCCESS(SENT)'" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SIGN(COUNT(COP_STS_CD)) CNT_FIN" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO=@[cntr_no]" ).append("\n"); 
		query.append("AND COP_STS_CD = 'F'" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SIGN(COUNT(CNMV_STS_CD)) CNT_CNMV" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO=@[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_STS_CD IN ('ID','MT')" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}