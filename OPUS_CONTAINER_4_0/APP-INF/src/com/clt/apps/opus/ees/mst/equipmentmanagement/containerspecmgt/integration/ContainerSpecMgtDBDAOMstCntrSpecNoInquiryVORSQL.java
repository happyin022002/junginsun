/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstCntrSpecNoInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.07.01 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOMstCntrSpecNoInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Container Creation에서 Spec No 조회
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMstCntrSpecNoInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMstCntrSpecNoInquiryVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("FROM  MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   SPEC.OWN_CNTR_FLG = 'N'" ).append("\n"); 
		query.append("AND   SPEC.CNTR_TPSZ_CD = @[sch_tpsz_cd]" ).append("\n"); 
		query.append("AND   CASE WHEN SPEC.CNTR_SPEC_TP_CD= 'S' THEN" ).append("\n"); 
		query.append("           DECODE(@[lstm_cd], 'SH', 'Y', 'MI', 'Y', 'SI', 'Y', 'OF', 'Y', 'ST', 'Y', 'N')" ).append("\n"); 
		query.append("      ELSE" ).append("\n"); 
		query.append("          DECODE(SPEC.VNDR_SEQ, @[vndr_seq], 'Y'" ).append("\n"); 
		query.append("                                           , DECODE(@[lstm_cd], 'SH', 'Y', 'MI', 'Y', 'SI', 'Y', 'OF', 'Y', 'ST', 'Y', 'N')" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("      END = 'Y'" ).append("\n"); 
		query.append("AND   SPEC.CNTR_SPEC_NO   = @[sch_spec_no]" ).append("\n"); 
		query.append("AND ROWNUM              = 1" ).append("\n"); 

	}
}