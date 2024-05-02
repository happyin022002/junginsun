/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODEmailSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODEmailSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Email Send 시 수신자
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODEmailSendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODEmailSendRSQL").append("\n"); 
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
		query.append("SELECT      SUBSTR( MAX( SYS_CONNECT_BY_PATH(PIC_EML, ';')),2) AS PIC_EML" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            SELECT      SLAN_CD" ).append("\n"); 
		query.append("                   ,    RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                   ,    PIC_EML" ).append("\n"); 
		query.append("                   ,    ROW_NUMBER() OVER (PARTITION BY SLAN_CD, RGN_SHP_OPR_CD ORDER BY SLAN_CD, RGN_SHP_OPR_CD) RN" ).append("\n"); 
		query.append("            FROM        (" ).append("\n"); 
		query.append("						SELECT		*" ).append("\n"); 
		query.append("						FROM		(" ).append("\n"); 
		query.append("									-----------------------------------------------------------" ).append("\n"); 
		query.append("                        			SELECT      DISTINCT" ).append("\n"); 
		query.append("                                    			PIC.SLAN_CD" ).append("\n"); 
		query.append("                              				,	PIC.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                              				,   PIC.PIC_EML" ).append("\n"); 
		query.append("											,	RANK() OVER (ORDER BY DECODE(PIC.VSL_OPR_CD,NULL,99,1) ASC) EML_RNK" ).append("\n"); 
		query.append("                        			FROM        VSK_LANE_PIC              PIC" ).append("\n"); 
		query.append("                        			WHERE       1 = 1" ).append("\n"); 
		query.append("									AND         PIC.LANE_PIC_TP_CD        = 'J'" ).append("\n"); 
		query.append("									AND			PIC.RGN_SHP_OPR_CD        = @[rso]                        " ).append("\n"); 
		query.append("                        			AND         PIC.SLAN_CD               = @[slan_cd]   " ).append("\n"); 
		query.append("									AND         (PIC.VSL_OPR_CD           = @[vsl_opr_cd]    " ).append("\n"); 
		query.append("									 			 OR" ).append("\n"); 
		query.append("									 			 PIC.VSL_OPR_CD           IS NULL" ).append("\n"); 
		query.append("												) " ).append("\n"); 
		query.append("									-----------------------------------------------------------" ).append("\n"); 
		query.append("                        			)" ).append("\n"); 
		query.append("						WHERE		EML_RNK		= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("            GROUP BY    SLAN_CD" ).append("\n"); 
		query.append("                   ,    RGN_SHP_OPR_CD " ).append("\n"); 
		query.append("                   ,    PIC_EML" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("START WITH  RN = 1" ).append("\n"); 
		query.append("CONNECT BY  PRIOR SLAN_CD  = SLAN_CD" ).append("\n"); 
		query.append("AND               RGN_SHP_OPR_CD = RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("AND               PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY          SLAN_CD,    RGN_SHP_OPR_CD" ).append("\n"); 

	}
}