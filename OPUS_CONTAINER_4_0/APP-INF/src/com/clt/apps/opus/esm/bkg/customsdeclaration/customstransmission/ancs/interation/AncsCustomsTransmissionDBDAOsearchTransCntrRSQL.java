/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchTransCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.05 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchTransCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchTransCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchTransCntrRSQL").append("\n"); 
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
		query.append("SELECT CNTR.CNTR_NO      AS CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR.CNTR_TPSZ_CD AS CNTR_TS" ).append("\n"); 
		query.append("      ,DECODE(BL.BKG_CGO_TP_CD, 'F', 'F', 'E') CNTR_FM" ).append("\n"); 
		query.append("      ,CNTR_WGT          AS CNTR_WGT" ).append("\n"); 
		query.append("      ,CNTR.ORG_RCV_TERM_CD||CNTR.DEST_DE_TERM_CD AS RD_TERM" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ANR_CNTR CNTR" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ANR_BL   BL" ).append("\n"); 
		query.append(" WHERE BL.VSL_CD     = CNTR.VSL_CD" ).append("\n"); 
		query.append("   AND BL.SKD_VOY_NO = CNTR.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND BL.SKD_DIR_CD = CNTR.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BL.BKG_NO     = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND BL.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("   AND BL.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND BL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND BL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${cntr_chk} != '')" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO IN (" ).append("\n"); 
		query.append("#foreach($cntrNo IN ${cntr_no})  " ).append("\n"); 
		query.append("'$cntrNo',  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}