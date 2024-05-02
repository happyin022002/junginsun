/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateInterfaceChgRevenueVVDCSRToLEACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.12.01 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateInterfaceChgRevenueVVDCSRToLEACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateInterfaceChgRevenueVVDCSRToLEA
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateInterfaceChgRevenueVVDCSRToLEACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GL_DT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateInterfaceChgRevenueVVDCSRToLEACSQL").append("\n"); 
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
		query.append("INSERT INTO LEA_ACT_COST_IF ( 		EXE_YRMON" ).append("\n"); 
		query.append(",	INV_SYS_ID" ).append("\n"); 
		query.append(",	IF_SEQ" ).append("\n"); 
		query.append(",	GL_DT" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BKG_NO_SPLIT" ).append("\n"); 
		query.append(",	COP_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	ACT_VVD_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",	COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",	COA_COST_SRC_CD         /* NEW : COA_COST_SRC_CD ; OLD : 20070418 - LGS_COST_CD         */" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	LOCL_COST_AMT" ).append("\n"); 
		query.append(",	ACCT_CD" ).append("\n"); 
		query.append(",	CSR_NO" ).append("\n"); 
		query.append(",	CSR_TP_CD" ).append("\n"); 
		query.append(",	INV_NO" ).append("\n"); 
		query.append(",	INV_VNDR_SEQ" ).append("\n"); 
		query.append(",	TTL_INV_KNT" ).append("\n"); 
		query.append(",	INV_CXL_FLG             /* INVOICE CANCEL FLAG */" ).append("\n"); 
		query.append(",	INV_CXL_DT              /* INVOICE CANCEL DATE */" ).append("\n"); 
		query.append(",	COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append(",	N1ST_NOD_CD" ).append("\n"); 
		query.append(",	N2ND_NOD_CD" ).append("\n"); 
		query.append(",	N3RD_NOD_CD" ).append("\n"); 
		query.append(",	N4TH_NOD_CD" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT         	SUBSTR(GL_DT,1,6)                                                                 	/* LEA.EXE_YRMON          	*/" ).append("\n"); 
		query.append(",	'TRS'                                                                             	/* LEA.INV_SYS_ID         	*/" ).append("\n"); 
		query.append(",	LEA_ACT_COST_IF_SEQ.NEXTVAL                                                       	/* LEA.IF_SEQ           	*/" ).append("\n"); 
		query.append(",	GL_DT                                                                            	/* LEA.GL_DT              	*/" ).append("\n"); 
		query.append(",	BKG_NO                                                                            	/* LEA.BKG_NO             	*/" ).append("\n"); 
		query.append(",	BKG_NO_SPLIT                                                                      	/* LEA.BKG_NO_SPLIT       	*/" ).append("\n"); 
		query.append(",	COP_NO                                                                            	/* LEA.COP_NO             	*/" ).append("\n"); 
		query.append(",	VSL_CD                                                                            	/* LEA.VSL_CD             	*/" ).append("\n"); 
		query.append(",	SKD_VOY_NO     					                                                    /* LEA.SKD_VOY_NO         	*/" ).append("\n"); 
		query.append(",	SKD_DIR_CD     					                                                    /* LEA.SKD_DIR_CD         	*/" ).append("\n"); 
		query.append(",	REV_DIR_CD							                                            	/* LEA.REV_DIR_CD         	*/" ).append("\n"); 
		query.append(",	ACT_VVD_CD													                        /* LEA.ACT_VVD_CD			*/" ).append("\n"); 
		query.append(",	CNTR_NO                                                                             /* LEA.CNTR_NO				*/" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD                                                                        /* LEA.CNTR_TPSZ_CD			*/" ).append("\n"); 
		query.append(",	COST_ACT_GRP_CD                                                                     /* LEA.COST_ACT_GRP_CD		*/" ).append("\n"); 
		query.append(",	COST_ACT_GRP_SEQ                                                                    /* LEA.COST_ACT_GRP_SEQ	 	*/" ).append("\n"); 
		query.append(", 	COA_COST_SRC_CD" ).append("\n"); 
		query.append(",	LOCL_CURR_CD                                                                        /* LEA.LOCL_CURR_CD			*/" ).append("\n"); 
		query.append(",	LOCL_COST_AMT     																	/* LEA.LOCL_COST_AMT		*/ /* INVOICE TOTAL AMOUNT */" ).append("\n"); 
		query.append(",	ACCT_CD														                        /* LEA.ACCT_CD				*/" ).append("\n"); 
		query.append(",	CSR_NO                                                                              /* LEA.CSR_NO				*/" ).append("\n"); 
		query.append(",	CSR_TP_CD                                                                           /* LEA.CSR_TP_CD			*/" ).append("\n"); 
		query.append(",	INV_NO                                                                              /* LEA.INV_NO				*/" ).append("\n"); 
		query.append(",	INV_VNDR_SEQ                                                                        /* LEA.INV_VNDR_SEQ			*/" ).append("\n"); 
		query.append(",	TTL_INV_KNT   																		/* LEA.TTL_INV_KNT			*/ /* CANCEL시에는 MINUS 값으로 넣는다. */" ).append("\n"); 
		query.append(",	INV_CXL_FLG                 														/* LEA.INV_CXL_FLG			*/ /* INVOICE CANCEL FLAG */" ).append("\n"); 
		query.append(",	INV_CXL_DT                  														/* LEA.INV_CXL_DT			*/ /* INVOICE CANCEL DATE */" ).append("\n"); 
		query.append(",	COST_ACT_GRP_TP_CD																	/* LEA.COST_ACT_GRP_TP_CD 	*/" ).append("\n"); 
		query.append(",	N1ST_NOD_CD                                                                     	/* LEA.N1ST_NOD_CD			*/" ).append("\n"); 
		query.append(",	N2ND_NOD_CD                                                                     	/* LEA.N2ND_NOD_CD			*/" ).append("\n"); 
		query.append(",	N3RD_NOD_CD                                                                     	/* LEA.N3RD_NOD_CD			*/" ).append("\n"); 
		query.append(",	N4TH_NOD_CD                                                                     	/* LEA.N4TH_NOD_CD			*/" ).append("\n"); 
		query.append(",	SYSDATE                                                                         	/* LEA.CRE_DT				*/" ).append("\n"); 
		query.append("FROM          	(" ).append("\n"); 
		query.append("SELECT  		'12'            						CSR_KND_INDICATOR" ).append("\n"); 
		query.append(", 	LAST_DAY(TO_DATE(@[GL_DT], 'YYYYMM')) 			GL_DT                       /* LEA.GL_DT              	*/" ).append("\n"); 
		query.append(",	A.BKG_NO                                                            /* LEA.BKG_NO             	*/" ).append("\n"); 
		query.append(",	A.BKG_NO_SPLIT                                                      /* LEA.BKG_NO_SPLIT       	*/" ).append("\n"); 
		query.append(",	A.COP_NO                                                            /* LEA.COP_NO             	*/" ).append("\n"); 
		query.append(",	A.VSL_CD                                                            /* LEA.VSL_CD             	*/" ).append("\n"); 
		query.append(",	A.SKD_VOY_NO     					                                /* LEA.SKD_VOY_NO         	*/" ).append("\n"); 
		query.append(",	A.SKD_DIR_CD     					                                /* LEA.SKD_DIR_CD         	*/" ).append("\n"); 
		query.append(",	A.REV_DIR_CD							                            /* LEA.REV_DIR_CD         	*/" ).append("\n"); 
		query.append(",	A.ACT_VVD_CD													    /* LEA.ACT_VVD_CD			*/" ).append("\n"); 
		query.append(",	A.CNTR_NO                                                           /* LEA.CNTR_NO				*/" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD                                                      /* LEA.CNTR_TPSZ_CD			*/" ).append("\n"); 
		query.append(",	A.COST_ACT_GRP_CD                                                   /* LEA.COST_ACT_GRP_CD		*/" ).append("\n"); 
		query.append(",	A.COST_ACT_GRP_SEQ                                                  /* LEA.COST_ACT_GRP_SEQ	 	*/" ).append("\n"); 
		query.append(", 	A.COA_COST_SRC_CD" ).append("\n"); 
		query.append(",	A.LOCL_CURR_CD                                                      /* LEA.LOCL_CURR_CD			*/" ).append("\n"); 
		query.append(",	A.LOCL_COST_AMT * (-1)  				LOCL_COST_AMT				/* LEA.LOCL_COST_AMT		*/ /* INVOICE TOTAL AMOUNT */" ).append("\n"); 
		query.append(",	A.ACCT_CD														    /* LEA.ACCT_CD				*/" ).append("\n"); 
		query.append(",	A.CSR_NO                                                            /* LEA.CSR_NO				*/" ).append("\n"); 
		query.append(",	A.CSR_TP_CD                                                         /* LEA.CSR_TP_CD			*/" ).append("\n"); 
		query.append(",	A.INV_NO                                                            /* LEA.INV_NO				*/" ).append("\n"); 
		query.append(",	A.INV_VNDR_SEQ                                                      /* LEA.INV_VNDR_SEQ			*/" ).append("\n"); 
		query.append(",	A.TTL_INV_KNT														/* LEA.TTL_INV_KNT			*/ /* CANCEL시에는 MINUS 값으로 넣는다. */" ).append("\n"); 
		query.append(",	'Y'										A.INV_CXL_FLG     			/* LEA.INV_CXL_FLG			*/ /* INVOICE CANCEL FLAG */" ).append("\n"); 
		query.append(",	A.INV_CXL_DT 														/* LEA.INV_CXL_DT			*/ /* INVOICE CANCEL DATE */" ).append("\n"); 
		query.append(",	A.COST_ACT_GRP_TP_CD												/* LEA.COST_ACT_GRP_TP_CD 	*/" ).append("\n"); 
		query.append(",	A.N1ST_NOD_CD                                                       /* LEA.N1ST_NOD_CD			*/" ).append("\n"); 
		query.append(",	A.N2ND_NOD_CD                                                       /* LEA.N2ND_NOD_CD			*/" ).append("\n"); 
		query.append(",	A.N3RD_NOD_CD                                                       /* LEA.N3RD_NOD_CD			*/" ).append("\n"); 
		query.append(",	A.N4TH_NOD_CD                                                       /* LEA.N4TH_NOD_CD			*/" ).append("\n"); 
		query.append("FROM    	LEA_ACT_COST_IF    A" ).append("\n"); 
		query.append(", 	LEA_REV_VVD_CNG    B" ).append("\n"); 
		query.append("WHERE   	B.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("AND     	B.BKG_NO_SPLIT     = A.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND     	B.OLD_VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     	B.OLD_REV_DIR_CD   = A.REV_DIR_CD" ).append("\n"); 
		query.append("AND     	B.CSR_NO           = @[CSR_NO]         /* OLD CSR NO. 		*/" ).append("\n"); 
		query.append("AND     	B.BKG_NO           = ''         /* BKG_NO. 			*/" ).append("\n"); 
		query.append("AND     	B.OLD_VSL_CD       = ''         /* OLD_VSL_CD. 		*/" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_VOY_NO   = ''         /* OLD_SKD_VOY_NO. 	*/" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_DIR_CD   = ''         /* OLD_SKD_DIR_CD. 	*/" ).append("\n"); 
		query.append("AND     	B.OLD_REV_DIR_CD   = ''         /* OLD_REV_DIR_CD. 	*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  	'14'            					CSR_KND_INDICATOR" ).append("\n"); 
		query.append(", 	LAST_DAY(TO_DATE(?, 'YYYYMM')) 		GL_DT                        	/* LEA.GL_DT              	*/" ).append("\n"); 
		query.append(",	A.BKG_NO                                                            /* LEA.BKG_NO             	*/" ).append("\n"); 
		query.append(",	A.BKG_NO_SPLIT                                                      /* LEA.BKG_NO_SPLIT       	*/" ).append("\n"); 
		query.append(",	A.COP_NO                                                            /* LEA.COP_NO             	*/" ).append("\n"); 
		query.append(",	B.NEW_VSL_CD                                                        /* LEA.VSL_CD             	*/" ).append("\n"); 
		query.append(",	B.NEW_SKD_VOY_NO     					                            /* LEA.SKD_VOY_NO         	*/" ).append("\n"); 
		query.append(",	B.NEW_SKD_DIR_CD     					                            /* LEA.SKD_DIR_CD         	*/" ).append("\n"); 
		query.append(",	B.NEW_REV_DIR_CD							                        /* LEA.REV_DIR_CD         	*/" ).append("\n"); 
		query.append(",	A.ACT_VVD_CD													    /* LEA.ACT_VVD_CD			*/" ).append("\n"); 
		query.append(",	A.CNTR_NO                                                           /* LEA.CNTR_NO				*/" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD                                                      /* LEA.CNTR_TPSZ_CD			*/" ).append("\n"); 
		query.append(",	A.COST_ACT_GRP_CD                                                   /* LEA.COST_ACT_GRP_CD		*/" ).append("\n"); 
		query.append(",	A.COST_ACT_GRP_SEQ                                                  /* LEA.COST_ACT_GRP_SEQ	 	*/" ).append("\n"); 
		query.append(", 	A.COA_COST_SRC_CD" ).append("\n"); 
		query.append(",	A.LOCL_CURR_CD                                                      /* LEA.LOCL_CURR_CD			*/" ).append("\n"); 
		query.append(",	A.LOCL_COST_AMT														/* LEA.LOCL_COST_AMT		*/ /* INVOICE TOTAL AMOUNT */" ).append("\n"); 
		query.append(",	A.ACCT_CD														    /* LEA.ACCT_CD				*/" ).append("\n"); 
		query.append(",	B.MODI_CSR_NO   					NEW_CSR_NO                      /* LEA.CSR_NO				*/" ).append("\n"); 
		query.append(",	'STANDARD'      					CSR_TP_CD                       /* LEA.CSR_TP_CD			*/" ).append("\n"); 
		query.append(",	A.INV_NO                                                            /* LEA.INV_NO				*/" ).append("\n"); 
		query.append(",	A.INV_VNDR_SEQ                                                      /* LEA.INV_VNDR_SEQ			*/" ).append("\n"); 
		query.append(",	A.TTL_INV_KNT														/* LEA.TTL_INV_KNT			*/ /* CANCEL시에는 MINUS 값으로 넣는다. */" ).append("\n"); 
		query.append(",	A.INV_CXL_FLG     													/* LEA.INV_CXL_FLG			*/ /* INVOICE CANCEL FLAG */" ).append("\n"); 
		query.append(",	A.INV_CXL_DT 														/* LEA.INV_CXL_DT			*/ /* INVOICE CANCEL DATE */" ).append("\n"); 
		query.append(",	A.COST_ACT_GRP_TP_CD												/* LEA.COST_ACT_GRP_TP_CD 	*/" ).append("\n"); 
		query.append(",	A.N1ST_NOD_CD                                                      	/* LEA.N1ST_NOD_CD			*/" ).append("\n"); 
		query.append(",	A.N2ND_NOD_CD                                                      	/* LEA.N2ND_NOD_CD			*/" ).append("\n"); 
		query.append(",	A.N3RD_NOD_CD                                                      	/* LEA.N3RD_NOD_CD			*/" ).append("\n"); 
		query.append(",	A.N4TH_NOD_CD                                                      	/* LEA.N4TH_NOD_CD			*/" ).append("\n"); 
		query.append("FROM    	LEA_ACT_COST_IF    A" ).append("\n"); 
		query.append(", 	LEA_REV_VVD_CNG    B" ).append("\n"); 
		query.append("WHERE   	B.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("AND     	B.BKG_NO_SPLIT     = A.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND     	B.OLD_VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     	B.OLD_REV_DIR_CD   = A.REV_DIR_CD" ).append("\n"); 
		query.append("AND     	B.CSR_NO           = ''         /* OLD CSR NO. */" ).append("\n"); 
		query.append("AND     	B.BKG_NO           = ''         /* BKG_NO. 			*/" ).append("\n"); 
		query.append("AND     	B.OLD_VSL_CD       = ''         /* OLD_VSL_CD. 		*/" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_VOY_NO   = ''         /* OLD_SKD_VOY_NO. 	*/" ).append("\n"); 
		query.append("AND     	B.OLD_SKD_DIR_CD   = ''         /* OLD_SKD_DIR_CD. 	*/" ).append("\n"); 
		query.append("AND     	B.OLD_REV_DIR_CD   = ''         /* OLD_REV_DIR_CD. 	*/" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}