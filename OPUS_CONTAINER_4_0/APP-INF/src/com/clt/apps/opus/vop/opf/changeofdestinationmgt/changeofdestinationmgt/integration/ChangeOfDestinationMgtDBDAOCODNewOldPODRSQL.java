/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
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

public class ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD의 NEW POD CD, OLD POD CD SELECT
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("AA.NEW_POD_CD," ).append("\n"); 
		query.append("(SELECT    ML.LOC_NM" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE      ML.LOC_CD     = AA.NEW_POD_CD" ).append("\n"); 
		query.append(") AS NEW_POD_FULL_NM," ).append("\n"); 
		query.append("AA.OLD_POD_CD," ).append("\n"); 
		query.append("(SELECT    ML.LOC_NM" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE      ML.LOC_CD     = AA.OLD_POD_CD" ).append("\n"); 
		query.append(") AS OLD_POD_FULL_NM," ).append("\n"); 
		query.append("(SELECT MAX(OB_CSSM_VOY_NO) " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD    = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD  = substr(@[vvd],9)" ).append("\n"); 
		query.append(") AS OB_CSSM_VOY_NO       " ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT    " ).append("\n"); 
		query.append("XX.BKG_NO" ).append("\n"); 
		query.append("      ,   XX.COD_RQST_SEQ" ).append("\n"); 
		query.append("      ,   DECODE(XX.N1ST_PORT_CD, YY.N1ST_PORT_CD, XX.N1ST_PORT_CD, 'ERROR')  ORIGINAL_LOAD_PORT_CD" ).append("\n"); 
		query.append("      ,   CASE WHEN XX.N2ND_PORT_CD <> YY.N2ND_PORT_CD                               THEN XX.N2ND_PORT_CD" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    CASE WHEN XX.N3RD_PORT_CD <> YY.N3RD_PORT_CD                     THEN XX.N3RD_PORT_CD" ).append("\n"); 
		query.append("                         ELSE" ).append("\n"); 
		query.append("                              CASE WHEN XX.N4TH_PORT_CD <> YY.N4TH_PORT_CD           THEN XX.N4TH_PORT_CD" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN XX.N5TH_PORT_CD <> YY.N5TH_PORT_CD THEN XX.N5TH_PORT_CD" ).append("\n"); 
		query.append("                                             ELSE                                         XX.N6TH_PORT_CD" ).append("\n"); 
		query.append("                                        END " ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("          END  OLD_POD_CD" ).append("\n"); 
		query.append("      ,   CASE WHEN XX.N2ND_PORT_CD <> YY.N2ND_PORT_CD                               THEN YY.N2ND_PORT_CD" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    CASE WHEN XX.N3RD_PORT_CD <> YY.N3RD_PORT_CD                     THEN YY.N3RD_PORT_CD" ).append("\n"); 
		query.append("                         ELSE" ).append("\n"); 
		query.append("                              CASE WHEN XX.N4TH_PORT_CD <> YY.N4TH_PORT_CD           THEN YY.N4TH_PORT_CD" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN XX.N5TH_PORT_CD <> YY.N5TH_PORT_CD THEN YY.N5TH_PORT_CD" ).append("\n"); 
		query.append("                                             ELSE                                         YY.N6TH_PORT_CD" ).append("\n"); 
		query.append("                                        END " ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("          END  NEW_POD_CD   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("          SELECT    X.BKG_NO" ).append("\n"); 
		query.append("                ,   X.COD_RQST_SEQ" ).append("\n"); 
		query.append("                ,   X.VVD_OP_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,1,SUBSTR(POL_YD_CD,1,5)))  N1ST_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,1,SUBSTR(POD_YD_CD,1,5)))  N2ND_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,2,SUBSTR(POD_YD_CD,1,5)))  N3RD_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,3,SUBSTR(POD_YD_CD,1,5)))  N4TH_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,4,SUBSTR(POD_YD_CD,1,5)))  N5TH_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,5,SUBSTR(POD_YD_CD,1,5)))  N6TH_PORT_CD" ).append("\n"); 
		query.append("          FROM      (    " ).append("\n"); 
		query.append("                    SELECT  ROWNUM           AS SEQ" ).append("\n"); 
		query.append("                        ,   V.BKG_NO" ).append("\n"); 
		query.append("                        ,   V.COD_RQST_SEQ" ).append("\n"); 
		query.append("                        ,   V.VVD_OP_CD" ).append("\n"); 
		query.append("                        ,   V.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                        ,   V.VSL_SEQ" ).append("\n"); 
		query.append("                        ,   V.POL_YD_CD" ).append("\n"); 
		query.append("                        ,   V.POD_YD_CD" ).append("\n"); 
		query.append("                    FROM    (" ).append("\n"); 
		query.append("                            SELECT    V.BKG_NO" ).append("\n"); 
		query.append("                                  ,   V.COD_RQST_SEQ" ).append("\n"); 
		query.append("                                  ,   V.VVD_OP_CD" ).append("\n"); 
		query.append("                                  ,   V.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                  ,   V.VSL_SEQ" ).append("\n"); 
		query.append("                                  ,   V.POL_YD_CD" ).append("\n"); 
		query.append("                                  ,   V.POD_YD_CD" ).append("\n"); 
		query.append("                            FROM      BKG_COD_VVD               V" ).append("\n"); 
		query.append("                            WHERE     1 = 1" ).append("\n"); 
		query.append("                            AND       V.VVD_OP_CD               = 'O'   /* O : OLD VVD */" ).append("\n"); 
		query.append("                            AND       V.BKG_NO                  = @[bkg_no]" ).append("\n"); 
		query.append("                            AND       V.COD_RQST_SEQ            = @[cod_rqst_seq]" ).append("\n"); 
		query.append("                            ORDER BY  V.VSL_PRE_PST_CD          ASC" ).append("\n"); 
		query.append("                                  ,   V.VSL_SEQ                 ASC" ).append("\n"); 
		query.append("                            ) V" ).append("\n"); 
		query.append("                    ) X" ).append("\n"); 
		query.append("          GROUP BY  X.BKG_NO" ).append("\n"); 
		query.append("                ,   X.COD_RQST_SEQ" ).append("\n"); 
		query.append("                ,   X.VVD_OP_CD" ).append("\n"); 
		query.append("          ) XX                        " ).append("\n"); 
		query.append("          ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("          SELECT    X.BKG_NO" ).append("\n"); 
		query.append("                ,   X.COD_RQST_SEQ" ).append("\n"); 
		query.append("                ,   X.VVD_OP_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,1,SUBSTR(POL_YD_CD,1,5)))  N1ST_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,1,SUBSTR(POD_YD_CD,1,5)))  N2ND_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,2,SUBSTR(POD_YD_CD,1,5)))  N3RD_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,3,SUBSTR(POD_YD_CD,1,5)))  N4TH_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,4,SUBSTR(POD_YD_CD,1,5)))  N5TH_PORT_CD" ).append("\n"); 
		query.append("                ,   MAX(DECODE(SEQ,5,SUBSTR(POD_YD_CD,1,5)))  N6TH_PORT_CD" ).append("\n"); 
		query.append("          FROM      (    " ).append("\n"); 
		query.append("                    SELECT  ROWNUM           AS SEQ" ).append("\n"); 
		query.append("                        ,   V.BKG_NO" ).append("\n"); 
		query.append("                        ,   V.COD_RQST_SEQ" ).append("\n"); 
		query.append("                        ,   V.VVD_OP_CD" ).append("\n"); 
		query.append("                        ,   V.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                        ,   V.VSL_SEQ" ).append("\n"); 
		query.append("                        ,   V.POL_YD_CD" ).append("\n"); 
		query.append("                        ,   V.POD_YD_CD" ).append("\n"); 
		query.append("                    FROM    (" ).append("\n"); 
		query.append("                            SELECT    V.BKG_NO" ).append("\n"); 
		query.append("                                  ,   V.COD_RQST_SEQ" ).append("\n"); 
		query.append("                                  ,   V.VVD_OP_CD" ).append("\n"); 
		query.append("                                  ,   V.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                  ,   V.VSL_SEQ" ).append("\n"); 
		query.append("                                  ,   V.POL_YD_CD" ).append("\n"); 
		query.append("                                  ,   V.POD_YD_CD" ).append("\n"); 
		query.append("                            FROM      BKG_COD_VVD               V" ).append("\n"); 
		query.append("                            WHERE     1 = 1" ).append("\n"); 
		query.append("                            AND       V.VVD_OP_CD               = 'N'   /* N : NEW VVD */" ).append("\n"); 
		query.append("                            AND       V.BKG_NO                  = @[bkg_no]" ).append("\n"); 
		query.append("                            AND       V.COD_RQST_SEQ            = @[cod_rqst_seq]" ).append("\n"); 
		query.append("                            ORDER BY  V.VSL_PRE_PST_CD          ASC" ).append("\n"); 
		query.append("                                  ,   V.VSL_SEQ                 ASC" ).append("\n"); 
		query.append("                            ) V" ).append("\n"); 
		query.append("                    ) X" ).append("\n"); 
		query.append("          GROUP BY  X.BKG_NO" ).append("\n"); 
		query.append("                ,   X.COD_RQST_SEQ" ).append("\n"); 
		query.append("                ,   X.VVD_OP_CD" ).append("\n"); 
		query.append("           ) YY" ).append("\n"); 
		query.append("WHERE      XX.BKG_NO           = YY.BKG_NO           " ).append("\n"); 
		query.append("AND        XX.COD_RQST_SEQ     = YY.COD_RQST_SEQ" ).append("\n"); 
		query.append(")AA" ).append("\n"); 

	}
}