/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorSoAckManageDBDAOaddKorSoAckListWoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.korsoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorSoAckManageDBDAOaddKorSoAckListWoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update TRS_TRSP_WRK_ORD_HIS
	  * </pre>
	  */
	public KorSoAckManageDBDAOaddKorSoAckListWoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_rslt_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.korsoack.integration ").append("\n"); 
		query.append("FileName : KorSoAckManageDBDAOaddKorSoAckListWoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD_HIS A SET" ).append("\n"); 
		query.append("A.WO_EDI_RCV_RSLT_CD		= @[edi_rcv_rslt_cd]" ).append("\n"); 
		query.append(", A.WO_EDI_RCV_RSLT_DT		= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[edi_rcv_rslt_dt])" ).append("\n"); 
		query.append(", A.WO_EDI_RCV_RSLT_MSG		= TRIM( REPLACE(@[edi_rcv_rslt_msg],  CHR(13)||CHR(10), ' '))" ).append("\n"); 
		query.append(", A.WO_EDI_RCV_PURP_CD		= @[edi_rcv_purp_cd]" ).append("\n"); 
		query.append("WHERE	TRSP_WO_OFC_CTY_CD			= @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND	A.TRSP_WO_SEQ					= TO_NUMBER(@[trsp_wo_seq])" ).append("\n"); 
		query.append("AND A.WO_ISS_KNT = (SELECT MAX(WO_ISS_KNT)" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("WHERE TRSP_WO_OFC_CTY_CD = A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ = A.TRSP_WO_SEQ)" ).append("\n"); 

	}
}