/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchTrspOrderInboundFromToRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : 강환
*@LastVersion : 1.0
* 2014.01.27 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchTrspOrderInboundFromToRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * - A/G SEQ가 빠른 S/O의 TO yard와 SEQ가 늦은 S/O의 From yard를 비교하여 동일하면
	  * A/G SEQ가 빠른  To yard는 Via yard로 인식하고 TN(EN)을 생성한다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchTrspOrderInboundFromToRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("event_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchTrspOrderInboundFromToRSQL").append("\n"); 
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
		query.append("	SELECT FM_TSO.FM_NOD_CD  AS FM_NOD_CD" ).append("\n"); 
		query.append("         , FM_TSO.TO_NOD_CD  AS TO_VIA_NOD_CD " ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD FM_TSO, TRS_TRSP_SVC_ORD TO_TSO" ).append("\n"); 
		query.append("	 WHERE FM_TSO.LOCL_CRE_DT BETWEEN TO_DATE(@[event_date],'YYYYMMDDHH24MI') - 20 AND TO_DATE(@[event_date],'YYYYMMDDHH24MI') + 7 " ).append("\n"); 
		query.append("	   AND FM_TSO.TRSP_SO_TP_CD = 'Y' " ).append("\n"); 
		query.append("	   AND FM_TSO.FM_NOD_CD = @[event_yard] " ).append("\n"); 
		query.append("	   AND FM_TSO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("	   AND FM_TSO.VIA_NOD_CD IS NULL" ).append("\n"); 
		query.append("     AND FM_TSO.TO_NOD_CD = TO_TSO.FM_NOD_CD" ).append("\n"); 
		query.append("     AND FM_TSO.COST_ACT_GRP_SEQ < TO_TSO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("     AND FM_TSO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND FM_TSO.EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("     AND FM_TSO.TRSP_BND_CD = TO_TSO.TRSP_BND_CD" ).append("\n"); 
		query.append("     AND FM_TSO.BKG_NO = TO_TSO.BKG_NO" ).append("\n"); 
		query.append("     AND FM_TSO.EQ_NO = TO_TSO.EQ_NO" ).append("\n"); 
		query.append("	   AND FM_TSO.DELT_FLG = 'N' " ).append("\n"); 
		query.append("	   AND TO_TSO.DELT_FLG = 'N' " ).append("\n"); 
		query.append("	   AND ROWNUM = 1" ).append("\n"); 

	}
}