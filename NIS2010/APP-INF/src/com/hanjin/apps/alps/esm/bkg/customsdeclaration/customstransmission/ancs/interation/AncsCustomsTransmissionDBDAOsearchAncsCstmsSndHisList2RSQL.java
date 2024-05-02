/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisList2RSQL").append("\n"); 
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
		query.append("#if (${target} == 'bl_log')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'B/L' AS DIV" ).append("\n"); 
		query.append(",EDI_SND_STS.ATTR_CTNT2 EDI_SND_STS_CD" ).append("\n"); 
		query.append(",HIS.EDI_SND_USR_ID" ).append("\n"); 
		query.append(",HIS.SND_OFC_CD" ).append("\n"); 
		query.append(",HIS.SND_DT" ).append("\n"); 
		query.append(",HIS.RCV_DT" ).append("\n"); 
		query.append(",HIS.ANR_DECL_NO" ).append("\n"); 
		query.append(",HIS.REF_SEQ" ).append("\n"); 
		query.append(",BLLOG.BL_NO AS BL_CNTR_NO" ).append("\n"); 
		query.append(",BLLOG.EDI_MSG_ERR_ID" ).append("\n"); 
		query.append(",BLLOG.ERR_DESC" ).append("\n"); 
		query.append(",EDI_RCV_STS.ATTR_CTNT2 EDI_RCV_STS_CD" ).append("\n"); 
		query.append(",HIS.VSL_CD || HIS.SKD_VOY_NO || HIS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS HIS" ).append("\n"); 
		query.append(",BKG_CSTMS_ANR_BL_LOG BLLOG" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_SND_STS" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_RCV_STS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BLLOG.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("AND HIS.MSG_TP_CD   = 'C'" ).append("\n"); 
		query.append("AND BLLOG.MSG_TP_CD(+)   = HIS.MSG_TP_CD" ).append("\n"); 
		query.append("AND BLLOG.ANR_DECL_NO(+) = HIS.ANR_DECL_NO" ).append("\n"); 
		query.append("AND BLLOG.REF_SEQ(+)     = HIS.REF_SEQ" ).append("\n"); 
		query.append("AND EDI_SND_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ES_STS_CD'" ).append("\n"); 
		query.append("AND EDI_SND_STS.ATTR_CTNT1(+) = HIS.EDI_SND_STS_CD" ).append("\n"); 
		query.append("AND EDI_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ER_STS_CD'" ).append("\n"); 
		query.append("AND EDI_RCV_STS.ATTR_CTNT1(+) = BLLOG.EDI_RCV_STS_CD" ).append("\n"); 
		query.append("ORDER BY HIS.REF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${target} == 'cntr_log')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'CNTR' AS DIV " ).append("\n"); 
		query.append(",EDI_SND_STS.ATTR_CTNT2 EDI_SND_STS_CD" ).append("\n"); 
		query.append(",HIS.EDI_SND_USR_ID" ).append("\n"); 
		query.append(",HIS.SND_OFC_CD" ).append("\n"); 
		query.append(",HIS.SND_DT" ).append("\n"); 
		query.append(",HIS.RCV_DT" ).append("\n"); 
		query.append(",HIS.ANR_DECL_NO" ).append("\n"); 
		query.append(",HIS.REF_SEQ" ).append("\n"); 
		query.append(",CNTRLOG.CNTR_NO AS BL_CNTR_NO" ).append("\n"); 
		query.append(",CNTRLOG.EDI_MSG_ERR_ID" ).append("\n"); 
		query.append(",CNTRLOG.ERR_DESC" ).append("\n"); 
		query.append(",EDI_RCV_STS.ATTR_CTNT2 EDI_RCV_STS_CD" ).append("\n"); 
		query.append(",HIS.VSL_CD || HIS.SKD_VOY_NO || HIS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS HIS " ).append("\n"); 
		query.append(",BKG_CSTMS_ANR_CNTR_LOG CNTRLOG" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_SND_STS" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_RCV_STS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTRLOG.CNTR_NO IN (SELECT B.CNTR_NO" ).append("\n"); 
		query.append("					    FROM BKG_CSTMS_ANR_BL A, BKG_CSTMS_ANR_CNTR B" ).append("\n"); 
		query.append("						WHERE 1=1" ).append("\n"); 
		query.append("						AND A.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("						AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("						AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND CNTRLOG.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND HIS.MSG_TP_CD   = 'C'" ).append("\n"); 
		query.append("AND CNTRLOG.MSG_TP_CD(+)   = HIS.MSG_TP_CD" ).append("\n"); 
		query.append("AND CNTRLOG.ANR_DECL_NO(+) = HIS.ANR_DECL_NO" ).append("\n"); 
		query.append("AND CNTRLOG.REF_SEQ(+)     = HIS.REF_SEQ" ).append("\n"); 
		query.append("AND EDI_SND_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ES_STS_CD'" ).append("\n"); 
		query.append("AND EDI_SND_STS.ATTR_CTNT1(+) = HIS.EDI_SND_STS_CD" ).append("\n"); 
		query.append("AND EDI_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ER_STS_CD'" ).append("\n"); 
		query.append("AND EDI_RCV_STS.ATTR_CTNT1(+) = CNTRLOG.EDI_RCV_STS_CD" ).append("\n"); 
		query.append("ORDER BY HIS.REF_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'B/L' AS DIV  " ).append("\n"); 
		query.append(",EDI_SND_STS.ATTR_CTNT2 EDI_SND_STS_CD" ).append("\n"); 
		query.append(",HIS.EDI_SND_USR_ID" ).append("\n"); 
		query.append(",HIS.SND_OFC_CD" ).append("\n"); 
		query.append(",HIS.SND_DT" ).append("\n"); 
		query.append(",HIS.RCV_DT" ).append("\n"); 
		query.append(",HIS.ANR_DECL_NO" ).append("\n"); 
		query.append(",HIS.REF_SEQ" ).append("\n"); 
		query.append(",BLLOG.BL_NO AS BL_CNTR_NO" ).append("\n"); 
		query.append(",BLLOG.EDI_MSG_ERR_ID" ).append("\n"); 
		query.append(",BLLOG.ERR_DESC" ).append("\n"); 
		query.append(",EDI_RCV_STS.ATTR_CTNT2 EDI_RCV_STS_CD" ).append("\n"); 
		query.append(",HIS.VSL_CD || HIS.SKD_VOY_NO || HIS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS HIS " ).append("\n"); 
		query.append(",BKG_CSTMS_ANR_BL_LOG BLLOG" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_SND_STS" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_RCV_STS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BLLOG.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("AND HIS.MSG_TP_CD   = 'C'" ).append("\n"); 
		query.append("AND BLLOG.MSG_TP_CD(+)   = HIS.MSG_TP_CD" ).append("\n"); 
		query.append("AND BLLOG.ANR_DECL_NO(+) = HIS.ANR_DECL_NO" ).append("\n"); 
		query.append("AND BLLOG.REF_SEQ(+)     = HIS.REF_SEQ" ).append("\n"); 
		query.append("AND EDI_SND_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ES_STS_CD'" ).append("\n"); 
		query.append("AND EDI_SND_STS.ATTR_CTNT1(+) = HIS.EDI_SND_STS_CD" ).append("\n"); 
		query.append("AND EDI_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ER_STS_CD'" ).append("\n"); 
		query.append("AND EDI_RCV_STS.ATTR_CTNT1(+) = BLLOG.EDI_RCV_STS_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'CNTR' AS DIV " ).append("\n"); 
		query.append(",EDI_SND_STS.ATTR_CTNT2 EDI_SND_STS_CD" ).append("\n"); 
		query.append(",HIS.EDI_SND_USR_ID" ).append("\n"); 
		query.append(",HIS.SND_OFC_CD" ).append("\n"); 
		query.append(",HIS.SND_DT" ).append("\n"); 
		query.append(",HIS.RCV_DT" ).append("\n"); 
		query.append(",HIS.ANR_DECL_NO" ).append("\n"); 
		query.append(",HIS.REF_SEQ" ).append("\n"); 
		query.append(",CNTRLOG.CNTR_NO AS BL_CNTR_NO" ).append("\n"); 
		query.append(",CNTRLOG.EDI_MSG_ERR_ID" ).append("\n"); 
		query.append(",CNTRLOG.ERR_DESC" ).append("\n"); 
		query.append("--,CNTRLOG.EDI_RCV_STS_CD" ).append("\n"); 
		query.append(",EDI_RCV_STS.ATTR_CTNT2 EDI_RCV_STS_CD" ).append("\n"); 
		query.append(",HIS.VSL_CD || HIS.SKD_VOY_NO || HIS.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS HIS " ).append("\n"); 
		query.append(",BKG_CSTMS_ANR_CNTR_LOG CNTRLOG" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_SND_STS" ).append("\n"); 
		query.append(",BKG_HRD_CDG_CTNT EDI_RCV_STS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTRLOG.ANR_DECL_NO IN (SELECT MAX(ANR_DECL_NO)" ).append("\n"); 
		query.append("					    FROM BKG_CSTMS_ANR_BL_LOG" ).append("\n"); 
		query.append("						WHERE 1=1" ).append("\n"); 
		query.append("						AND BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("AND CNTRLOG.CNTR_NO IN (SELECT B.CNTR_NO" ).append("\n"); 
		query.append("					    FROM BKG_CSTMS_ANR_BL A, BKG_CSTMS_ANR_CNTR B" ).append("\n"); 
		query.append("						WHERE 1=1" ).append("\n"); 
		query.append("						AND A.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("						AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("						AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND CNTRLOG.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND HIS.MSG_TP_CD   = 'C'" ).append("\n"); 
		query.append("AND CNTRLOG.MSG_TP_CD(+)   = HIS.MSG_TP_CD" ).append("\n"); 
		query.append("AND CNTRLOG.ANR_DECL_NO(+) = HIS.ANR_DECL_NO" ).append("\n"); 
		query.append("AND CNTRLOG.REF_SEQ(+)     = HIS.REF_SEQ" ).append("\n"); 
		query.append("AND EDI_SND_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ES_STS_CD'" ).append("\n"); 
		query.append("AND EDI_SND_STS.ATTR_CTNT1(+) = HIS.EDI_SND_STS_CD" ).append("\n"); 
		query.append("AND EDI_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_ER_STS_CD'" ).append("\n"); 
		query.append("AND EDI_RCV_STS.ATTR_CTNT1(+) = CNTRLOG.EDI_RCV_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY REF_SEQ, DIV" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}