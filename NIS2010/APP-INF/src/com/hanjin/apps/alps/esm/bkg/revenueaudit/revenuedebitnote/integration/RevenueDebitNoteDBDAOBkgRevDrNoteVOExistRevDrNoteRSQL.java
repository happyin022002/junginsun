/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 진행중인 RDN 번호를 조회한다.
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL").append("\n"); 
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
		query.append("SELECT  MAX(RDN_NO) RDN_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  RDN_NO    ," ).append("\n"); 
		query.append("                RDN_STS_CD" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("        WHERE   RDN_KND_CD = @[rdn_knd_cd]" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("        AND     BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("        AND     INV_NO    = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("        AND     VVD_CD    = @[vvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${inv_no} == '' && ${vvd_cd} == '')" ).append("\n"); 
		query.append("        AND     RDN_NO    = @[rdn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                            SELECT  'X'" ).append("\n"); 
		query.append("                            FROM  BKG_REV_DR_NOTE B" ).append("\n"); 
		query.append("                            WHERE B.RDN_NO    = A.RDN_NO" ).append("\n"); 
		query.append("                            AND   B.RVIS_SEQ  > A.RVIS_SEQ" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   RDN_STS_CD  NOT IN ( 'ST', 'CL', 'CV' )" ).append("\n"); 

	}
}